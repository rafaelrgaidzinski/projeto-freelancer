package com.example.freelancer.services;

import com.example.freelancer.models.CotacaoModel;
import com.example.freelancer.repositories.CotacaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

@Service
public class CotacaoService {

    @PostConstruct
    public void init() throws JSONException, IOException, ParseException, InterruptedException {
        requisicao();
    }

    @Autowired
    CotacaoRepository cotacaoRepository;

    @Transactional
    public CotacaoModel save(CotacaoModel cotacaoModel) {
        return cotacaoRepository.save(cotacaoModel);
    }

    @Transactional
    public void delete(CotacaoModel cotacaoModel) {
        cotacaoRepository.delete(cotacaoModel);
    }

    public Optional<CotacaoModel> findById(UUID id) {
        return cotacaoRepository.findById(id);
    }

    public List<CotacaoModel> findAll() {
        return cotacaoRepository.findAll();
    }

    public void requisicao() throws IOException, InterruptedException, JSONException, ParseException {

        String path = "https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,GBP-BRL,ARS-BRL";

        // Cria um cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Cria uma requisição HTTP
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(path)).build();

        // Resposta da requisição
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        List<CotacaoModel> listaCotacao = formatarCotacoes(response.body());

        for (CotacaoModel cotacaoModel : listaCotacao) {
            save(cotacaoModel);
        }

    }

    public static List<CotacaoModel> formatarCotacoes(String cotacoes) throws JsonProcessingException, ParseException {

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Map<String, Object> jsonCotacoes = objectMapper.readValue(cotacoes, Map.class);

        List<CotacaoModel> listaCotacoes = new ArrayList<>();;

        for (Map.Entry<String, Object> cotacao : jsonCotacoes.entrySet()) {

            Map dadosCotacao = (Map) cotacao.getValue();

            String conversao = dadosCotacao.get("codein") + "-" + dadosCotacao.get("code");
            String moedaConverter = dadosCotacao.get("name").toString().split("/")[1];
            String moedaConversao = dadosCotacao.get("name").toString().split("/")[0];
            Double compra = Double.parseDouble((String) dadosCotacao.get("bid"));
            Double venda = Double.parseDouble((String) dadosCotacao.get("ask"));
            Date dataCotacao = dateFormat.parse((String) dadosCotacao.get("create_date"));

            CotacaoModel cotacaoModel = new CotacaoModel(conversao, moedaConverter, moedaConversao, compra,venda, dataCotacao);

            listaCotacoes.add(cotacaoModel);
        }

        return listaCotacoes;
    }
}
