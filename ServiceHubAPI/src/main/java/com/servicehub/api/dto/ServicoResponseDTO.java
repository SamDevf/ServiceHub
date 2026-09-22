package com.servicehub.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(name = "ServicoResponse", description = "Representação de um serviço retornado pela API")
public record ServicoResponseDTO(
        @Schema(description = "Identificador único do serviço", example = "1")
        Long id,

        @Schema(description = "Nome do serviço", example = "Limpeza residencial")
        String nome,

        @Schema(description = "Descrição detalhada do serviço", example = "Limpeza completa de casa com produtos ecológicos")
        String descricao,

        @Schema(description = "Preço do serviço em reais", example = "150.00")
        BigDecimal preco,

        @Schema(description = "Categoria do serviço", example = "Casa")
        String categoria,

        @Schema(description = "Status do serviço", example = "true")
        Boolean ativo,

        @Schema(description = "Data de criação do cadastro do serviço", example = "2026-09-22T16:02:18")
        LocalDateTime dataCriacao
) {
}
