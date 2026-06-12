package com.copa.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SelecaoDTO {

    private Long id;

    @NotBlank(message = "O nome do país é obrigatório")
    private String nomePais;

    @NotBlank(message = "O nome do técnico é obrigatório")
    private String tecnico;

    private Integer rankingFifa;

}