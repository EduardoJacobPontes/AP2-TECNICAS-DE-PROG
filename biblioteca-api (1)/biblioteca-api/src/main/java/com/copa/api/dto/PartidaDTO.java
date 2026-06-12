package com.copa.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartidaDTO {

    private Long id;

    @NotNull(message = "A data da partida é obrigatória")
    private LocalDate data;

    @NotBlank(message = "O estádio é obrigatório")
    private String estadio;

    @NotBlank(message = "A fase da competição é obrigatória")
    private String faseCompeticao;

    private String placar;

    @NotEmpty(message = "Informe os IDs das seleções participantes")
    private List<Long> selecoesIds;

    private List<String> nomesSelecoes;

}