package com.copa.api.service.impl;

import com.copa.api.dto.JogadorDTO;
import com.copa.api.entity.Jogador;
import com.copa.api.entity.Selecao;
import com.copa.api.exception.ResourceNotFoundException;
import com.copa.api.mapper.JogadorMapper;
import com.copa.api.repository.JogadorRepository;
import com.copa.api.repository.SelecaoRepository;
import com.copa.api.service.JogadorService;
import com.copa.api.strategy.ValidationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JogadorServiceImpl implements JogadorService {

    private final JogadorRepository jogadorRepository;
    private final SelecaoRepository selecaoRepository;
    private final JogadorMapper jogadorMapper;

    // Injeção da estratégia de validação (Design Pattern: Strategy)
    private final ValidationStrategy<JogadorDTO> validationStrategy;

    @Override
    @Transactional
    public JogadorDTO criar(JogadorDTO dto) {
        // 1. Aplica a validação de regras de negócio (ex: verificar se tem 15 anos ou mais)
        validationStrategy.validate(dto);

        // 2. Verifica se a seleção informada existe
        Selecao selecao = selecaoRepository.findById(dto.getSelecaoId())
                .orElseThrow(() -> new ResourceNotFoundException("Seleção não encontrada com o id: " + dto.getSelecaoId()));

        // 3. Converte e guarda na base de dados
        Jogador jogador = jogadorMapper.toEntity(dto);
        jogador.setSelecao(selecao);

        return jogadorMapper.toDTO(jogadorRepository.save(jogador));
    }

    @Override
    public JogadorDTO buscarPorId(Long id) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jogador não encontrado com o id: " + id));
        return jogadorMapper.toDTO(jogador);
    }

    @Override
    public List<JogadorDTO> listarTodos() {
        return jogadorRepository.findAll().stream()
                .map(jogadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public JogadorDTO atualizar(Long id, JogadorDTO dto) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jogador não encontrado com o id: " + id));

        Selecao selecao = selecaoRepository.findById(dto.getSelecaoId())
                .orElseThrow(() -> new ResourceNotFoundException("Seleção não encontrada com o id: " + dto.getSelecaoId()));

        jogador.setNome(dto.getNome());
        jogador.setNumeroCamisa(dto.getNumeroCamisa());
        jogador.setPosicao(dto.getPosicao());
        jogador.setIdade(dto.getIdade());
        jogador.setSelecao(selecao);

        return jogadorMapper.toDTO(jogadorRepository.save(jogador));
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jogador não encontrado com o id: " + id));
        jogadorRepository.delete(jogador);
    }

}