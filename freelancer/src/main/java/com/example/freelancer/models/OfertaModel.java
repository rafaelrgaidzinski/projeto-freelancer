package com.example.freelancer.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_ofertas")
public class OfertaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 30)
    private String tituloVaga;
    @Column(nullable = false)
    private UUID idEstabeleimento;
    @Column(nullable = false, length = 300)
    private String descricaoVaga;
    @Column(nullable = false)
    private Double valorServico;
    @Column(nullable = false)
    private Date dataInicioServico;
    @Column(nullable = false)
    private Date dataFimServico;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTituloVaga() {
        return tituloVaga;
    }

    public void setTituloVaga(String tituloVaga) {
        this.tituloVaga = tituloVaga;
    }

    public UUID getIdEstabeleimento() {
        return idEstabeleimento;
    }

    public void setIdEstabeleimento(UUID idEstabeleimento) {
        this.idEstabeleimento = idEstabeleimento;
    }

    public String getDescricaoVaga() {
        return descricaoVaga;
    }

    public void setDescricaoVaga(String descricaoVaga) {
        this.descricaoVaga = descricaoVaga;
    }

    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public Date getDataInicioServico() {
        return dataInicioServico;
    }

    public void setDataInicioServico(Date dataInicioServico) {
        this.dataInicioServico = dataInicioServico;
    }

    public Date getDataFimServico() {
        return dataFimServico;
    }

    public void setDataFimServico(Date dataFimServico) {
        this.dataFimServico = dataFimServico;
    }
}
