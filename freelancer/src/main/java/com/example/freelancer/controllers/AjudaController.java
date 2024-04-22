package com.example.freelancer.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ajuda")
@Scope("prototype")
public class AjudaController {

    @GetMapping
    public ResponseEntity<Object> getAjuda() {

        Map<String, String> informacoesProjeto = new HashMap<>();
        informacoesProjeto.put("estudante", "Rafael Ronsoni Gaidzinski");
        informacoesProjeto.put("projeto", "Aplicativo de vagas para freelancers");
        return ResponseEntity.status(HttpStatus.OK).body(informacoesProjeto);
    }

}
