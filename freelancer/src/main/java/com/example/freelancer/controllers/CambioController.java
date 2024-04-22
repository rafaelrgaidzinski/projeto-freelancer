package com.example.freelancer.controllers;

import com.example.freelancer.models.EstabelecimentoModel;
import com.example.freelancer.services.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cambio")
@Scope("prototype")
public class CambioController {

    @Autowired
    CambioService cambioService;

    @GetMapping
    public ResponseEntity<Object> getCambio() throws IOException, InterruptedException {
        String resposta = cambioService.requisicao();
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }
}
