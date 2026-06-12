package com.copa.api.mapper;

import com.copa.api.dto.SelecaoDTO;
import com.copa.api.entity.Selecao;
import org.springframework.stereotype.Component;

// Cumpre os padrões de Clean Code (Separação entre Entidade de Banco e DTO de Exposição)
@Component
public class SelecaoMapper {

    public SelecaoDTO toDTO(Selecao selecao) {
        return SelecaoDTO.builder()
                .id(selecao.getId())
                .nomePais(selecao.getNomePais())
                .tecnico(selecao.getTecnico())
                .rankingFifa(selecao.getRankingFifa())
                .build();
    }

    public Selecao toEntity(SelecaoDTO dto) {
        Selecao selecao = new Selecao();
        selecao.setNomePais(dto.getNomePais());
        selecao.setTecnico(dto.getTecnico());
        selecao.setRankingFifa(dto.getRankingFifa());
        return selecao;
    }

    public void atualizarEntidade(SelecaoDTO dto, Selecao selecao) {
        selecao.setNomePais(dto.getNomePais());
        selecao.setTecnico(dto.getTecnico());
        selecao.setRankingFifa(dto.getRankingFifa());
    }

}