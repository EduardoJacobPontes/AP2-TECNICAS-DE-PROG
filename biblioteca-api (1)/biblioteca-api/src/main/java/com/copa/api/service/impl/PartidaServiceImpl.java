package com.copa.api.service.impl;

import com.copa.api.dto.PartidaDTO;
import com.copa.api.entity.Partida;
import com.copa.api.entity.Selecao;
import com.copa.api.exception.ResourceNotFoundException;
import com.copa.api.mapper.PartidaMapper;
import com.copa.api.repository.PartidaRepository;
import com.copa.api.repository.SelecaoRepository;
import com.copa.api.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartidaServiceImpl implements PartidaService {

    private final PartidaRepository partidaRepository;
    private final SelecaoRepository selecaoRepository;
    private final PartidaMapper partidaMapper;

    @Override
    @Transactional
    public PartidaDTO criar(PartidaDTO dto) {
        // Regra de negócio: Uma partida de futebol tem de ter obrigatoriamente 2 equipas (seleções)
        if (dto.getSelecoesIds() == null || dto.getSelecoesIds().size() != 2) {
            throw new IllegalArgumentException("Uma partida deve conter exatamente 2 seleções.");
        }

        List<Selecao> selecoes = selecaoRepository.findAllById(dto.getSelecoesIds());
        if (selecoes.size() != 2) {
            throw new ResourceNotFoundException("Uma ou mais seleções informadas não foram encontradas na base de dados.");
        }

        Partida partida = partidaMapper.toEntity(dto);
        partida.setSelecoes(selecoes); // Associa as seleções (Relacionamento N:N)

        return partidaMapper.toDTO(partidaRepository.save(partida));
    }

    @Override
    public PartidaDTO buscarPorId(Long id) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partida não encontrada com o id: " + id));
        return partidaMapper.toDTO(partida);
    }

    @Override
    public List<PartidaDTO> listarTodos() {
        return partidaRepository.findAll().stream()
                .map(partidaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PartidaDTO atualizar(Long id, PartidaDTO dto) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partida não encontrada com o id: " + id));

        if (dto.getSelecoesIds() == null || dto.getSelecoesIds().size() != 2) {
            throw new IllegalArgumentException("Uma partida deve conter exatamente 2 seleções.");
        }

        List<Selecao> selecoes = selecaoRepository.findAllById(dto.getSelecoesIds());
        if (selecoes.size() != 2) {
            throw new ResourceNotFoundException("Uma ou mais seleções informadas não foram encontradas na base de dados.");
        }

        partidaMapper.atualizarEntidade(dto, partida);
        partida.setSelecoes(selecoes);

        return partidaMapper.toDTO(partidaRepository.save(partida));
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partida não encontrada com o id: " + id));
        partidaRepository.delete(partida);
    }

}