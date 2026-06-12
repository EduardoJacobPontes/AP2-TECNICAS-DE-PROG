package com.copa.api.mapper;

import com.copa.api.dto.JogadorDTO;
import com.copa.api.entity.Jogador;
import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {

    public JogadorDTO toDTO(Jogador jogador) {
        return JogadorDTO.builder()
                .id(jogador.getId())
                .nome(jogador.getNome())
                .numeroCamisa(jogador.getNumeroCamisa())
                .posicao(jogador.getPosicao())
                .idade(jogador.getIdade())
                // Mapeia os dados do relacionamento 1:N
                .selecaoId(jogador.getSelecao().getId())
                .nomeSelecao(jogador.getSelecao().getNomePais())
                .build();
    }

    public Jogador toEntity(JogadorDTO dto) {
        Jogador jogador = new Jogador();
        jogador.setNome(dto.getNome());
        jogador.setNumeroCamisa(dto.getNumeroCamisa());
        jogador.setPosicao(dto.getPosicao());
        jogador.setIdade(dto.getIdade());
        // A seleção é "setada" no Service, não aqui no Mapper,
        // para garantir que a entidade existe na base de dados.
        return jogador;
    }

}