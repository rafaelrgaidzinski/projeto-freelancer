package com.example.freelancer.controllers;

import com.example.freelancer.dtos.EstabelecimentoRecordDto;
import com.example.freelancer.models.EstabelecimentoModel;
import com.example.freelancer.services.EstabelecimentoService;
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
@RequestMapping("/estabelecimento")
@Scope("prototype")
public class EstabelecimentoController {

    @Autowired
    EstabelecimentoService estabelecimentoService;

    @PostMapping
    public ResponseEntity<EstabelecimentoModel> saveEstabelecimento(@RequestBody @Valid EstabelecimentoRecordDto estabelecimentoRecordDto){
        var estabelecimentoModel = new EstabelecimentoModel();
        BeanUtils.copyProperties(estabelecimentoRecordDto, estabelecimentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(estabelecimentoService.save(estabelecimentoModel));
    }

    @GetMapping
    public ResponseEntity<List<EstabelecimentoModel>> getEstabelecimentos() {
        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEstabelecimento(@PathVariable(value = "id") UUID id) {
        Optional<EstabelecimentoModel> estabelecimentoModelOptional = estabelecimentoService.findById(id);
        if(estabelecimentoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estabelecimento não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEstabelecimento(@PathVariable(value = "id") UUID id) {
        Optional<EstabelecimentoModel> estabelecimentoModelOptional = estabelecimentoService.findById(id);
        if(estabelecimentoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estabelecimento não encontrado.");
        }
        var estabelecimentoModel = new EstabelecimentoModel();
        BeanUtils.copyProperties(estabelecimentoModelOptional.get(), estabelecimentoModel);
        estabelecimentoModel.setId(estabelecimentoModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoService.save(estabelecimentoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEstabelecimento(@PathVariable(value = "id") UUID id) {
        Optional<EstabelecimentoModel> estabelecimentoModelOptional = estabelecimentoService.findById(id);
        if(estabelecimentoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estabelecimento não encontrado.");
        }
        estabelecimentoService.delete(estabelecimentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Estabelecimento excluído com sucesso.");
    }

}
