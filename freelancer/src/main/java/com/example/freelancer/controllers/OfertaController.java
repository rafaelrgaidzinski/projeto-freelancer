package com.example.freelancer.controllers;

import com.example.freelancer.dtos.OfertaRecordDto;
import com.example.freelancer.models.OfertaModel;
import com.example.freelancer.services.OfertaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/ofertas")
@Scope("prototype")
public class OfertaController {

    @Autowired
    OfertaService ofertaService;

    @PostMapping
    public ResponseEntity<OfertaModel> saveOferta(@RequestBody @Valid OfertaRecordDto ofertaRecordDto){
        var ofertaModel = new OfertaModel();
        BeanUtils.copyProperties(ofertaRecordDto, ofertaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(ofertaService.save(ofertaModel));
    }

    @GetMapping
    public ResponseEntity<List<OfertaModel>> getOfertas() {
        return ResponseEntity.status(HttpStatus.OK).body(ofertaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOferta(@PathVariable(value = "id") UUID id) {
        Optional<OfertaModel> ofertaModelOptional = ofertaService.findById(id);
        if(ofertaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oferta não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ofertaModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOferta(@PathVariable(value = "id") UUID id) {
        Optional<OfertaModel> ofertaModelOptional = ofertaService.findById(id);
        if(ofertaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oferta não encontrada.");
        }
        var ofertaModel = new OfertaModel();
        BeanUtils.copyProperties(ofertaModelOptional.get(), ofertaModel);
        ofertaModel.setId(ofertaModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(ofertaService.save(ofertaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOferta(@PathVariable(value = "id") UUID id) {
        Optional<OfertaModel> ofertaModelOptional = ofertaService.findById(id);
        if(ofertaModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oferta não encontrada.");
        }
        ofertaService.delete(ofertaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Oferta excluída com sucesso.");
    }
}
