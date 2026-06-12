package com.copa.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JogadorDTO {

    private Long id;

    @NotBlank(message = "O nome do jogador é obrigatório")
    private String nome;

    @NotNull(message = "O número da camisa é obrigatório")
    private Integer numeroCamisa;

    @NotBlank(message = "A posição é obrigatória")
    private String posicao;

    private Integer idade;

    @NotNull(message = "O ID da seleção é obrigatório")
    private Long selecaoId;

    private String nomeSelecao;

}