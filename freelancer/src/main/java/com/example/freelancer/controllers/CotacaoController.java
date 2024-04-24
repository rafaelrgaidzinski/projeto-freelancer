package com.example.freelancer.controllers;

import com.example.freelancer.models.CotacaoModel;
import com.example.freelancer.models.OfertaModel;
import com.example.freelancer.services.CotacaoService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cotacoes")
@Scope("prototype")
public class CotacaoController {

    @Autowired
    CotacaoService cotacaoService;

    @GetMapping
    public ResponseEntity<List<CotacaoModel>> getCotacoes() throws JSONException, IOException, InterruptedException, ParseException {
        return ResponseEntity.status(HttpStatus.OK).body(cotacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCotacao(@PathVariable(value = "id") UUID id) {
        Optional<CotacaoModel> cotacaoModelOptional = cotacaoService.findById(id);
        if(cotacaoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cotação não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cotacaoModelOptional.get());
    }

}
