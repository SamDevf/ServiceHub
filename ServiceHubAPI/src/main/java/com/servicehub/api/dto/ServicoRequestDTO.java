package com.servicehub.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Schema(name = "ServicoRequest", description = "Dados para cadastro ou atualização de um serviço")
public record ServicoRequestDTO(
        @Schema(description = "Nome do serviço", example = "Limpeza residencial", minLength = 3, maxLength = 120)
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(min = 3, max = 120, message = "O nome deve ter entre 3 e 120 caracteres")
        String nome,

        @Schema(description = "Descrição detalhada do serviço", example = "Limpeza completa de casa com produtos ecológicos", minLength = 10, maxLength = 500)
        @NotBlank(message = "A descrição não pode estar em branco")
        @Size(min = 10, max = 500, message = "A descrição deve ter entre 10 e 500 caracteres")
        String descricao,

        @Schema(description = "Preço do serviço em reais", example = "150.00")
        @NotNull(message = "O preço é obrigatório")
        @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
        BigDecimal preco,

        @Schema(description = "Categoria do serviço", example = "Casa")
        @NotBlank(message = "A categoria não pode estar em branco")
        @Size(min = 2, max = 80, message = "A categoria deve ter entre 2 e 80 caracteres")
        String categoria,

        @Schema(description = "Indica se o serviço está ativo para uso", example = "true")
        @NotNull(message = "O campo ativo é obrigatório")
        Boolean ativo
) {
}
