package com.example.freelancer.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record OfertaRecordDto(@NotBlank String tituloVaga, @NotNull UUID idEstabelecimento, @NotBlank String descricaoVaga, @NotNull Double valorServico, @NotNull Date dataInicioServico, @NotNull Date dataFimServico) {
}
