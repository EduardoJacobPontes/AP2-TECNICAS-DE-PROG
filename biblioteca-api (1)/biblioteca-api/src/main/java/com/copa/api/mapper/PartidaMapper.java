package com.copa.api.mapper;

import com.copa.api.dto.PartidaDTO;
import com.copa.api.entity.Partida;
import com.copa.api.entity.Selecao;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PartidaMapper {

    public PartidaDTO toDTO(Partida partida) {
        return PartidaDTO.builder()
                .id(partida.getId())
                .data(partida.getData())
                .estadio(partida.getEstadio())
                .faseCompeticao(partida.getFaseCompeticao())
                .placar(partida.getPlacar())
                // Extrai a lista de IDs das seleções envolvidas
                .selecoesIds(partida.getSelecoes() != null ?
                        partida.getSelecoes().stream().map(Selecao::getId).collect(Collectors.toList()) : null)
                // Extrai a lista de Nomes das seleções envolvidas
                .nomesSelecoes(partida.getSelecoes() != null ?
                        partida.getSelecoes().stream().map(Selecao::getNomePais).collect(Collectors.toList()) : null)
                .build();
    }

    public Partida toEntity(PartidaDTO dto) {
        Partida partida = new Partida();
        partida.setData(dto.getData());
        partida.setEstadio(dto.getEstadio());
        partida.setFaseCompeticao(dto.getFaseCompeticao());
        partida.setPlacar(dto.getPlacar());
        return partida;
    }

    public void atualizarEntidade(PartidaDTO dto, Partida partida) {
        partida.setData(dto.getData());
        partida.setEstadio(dto.getEstadio());
        partida.setFaseCompeticao(dto.getFaseCompeticao());
        partida.setPlacar(dto.getPlacar());
    }

}