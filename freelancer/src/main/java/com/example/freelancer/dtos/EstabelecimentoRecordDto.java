package com.example.freelancer.dtos;

import jakarta.validation.constraints.NotBlank;

public record EstabelecimentoRecordDto(@NotBlank String nome, @NotBlank String cnpj, @NotBlank String telefone, @NotBlank String email, @NotBlank String endereco) {
}
