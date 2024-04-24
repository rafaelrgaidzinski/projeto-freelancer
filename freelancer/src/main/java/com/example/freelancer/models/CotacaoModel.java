package com.example.freelancer.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_cotacoes")
public class CotacaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 10)
    private String conversao;

    @Column(nullable = false, length = 20)
    private String moedaConverter;

    @Column(nullable = false, length = 20)
    private String moedaConversao;

    @Column(nullable = false)
    private Double compra;

    @Column(nullable = false)
    private Double venda;

    @Column(nullable = false)
    private Date dataCotacao;

    public CotacaoModel() {}

    public CotacaoModel(String conversao, String moedaConverter, String moedaConversao, Double compra, Double venda, Date dataCotacao) {
        this.conversao = conversao;
        this.moedaConverter = moedaConverter;
        this.moedaConversao = moedaConversao;
        this.compra = compra;
        this.venda = venda;
        this.dataCotacao = dataCotacao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getConversao() {
        return conversao;
    }

    public void setConversao(String conversao) {
        this.conversao = conversao;
    }

    public String getMoedaConverter() {
        return moedaConverter;
    }

    public void setMoedaConverter(String moedaConverter) {
        this.moedaConverter = moedaConverter;
    }

    public String getMoedaConversao() {
        return moedaConversao;
    }

    public void setMoedaConversao(String moedaConversao) {
        this.moedaConversao = moedaConversao;
    }

    public Double getCompra() {
        return compra;
    }

    public void setCompra(Double compra) {
        this.compra = compra;
    }

    public Double getVenda() {
        return venda;
    }

    public void setVenda(Double venda) {
        this.venda = venda;
    }

    public Date getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(Date dataCotacao) {
        this.dataCotacao = dataCotacao;
    }
}
