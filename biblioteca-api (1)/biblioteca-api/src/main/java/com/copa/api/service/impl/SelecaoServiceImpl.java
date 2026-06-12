package com.copa.api.service.impl;

import com.copa.api.dto.SelecaoDTO;
import com.copa.api.entity.Selecao;
import com.copa.api.exception.ResourceNotFoundException;
import com.copa.api.mapper.SelecaoMapper;
import com.copa.api.repository.SelecaoRepository;
import com.copa.api.service.SelecaoService;
import com.copa.api.strategy.ValidationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SelecaoServiceImpl implements SelecaoService {

    private final SelecaoRepository selecaoRepository;
    private final SelecaoMapper selecaoMapper;
    private final ValidationStrategy<SelecaoDTO> validationStrategy;

    @Override
    @Transactional
    public SelecaoDTO criar(SelecaoDTO dto) {
        // Usa o Design Pattern Strategy para validar se a seleção já existe
        validationStrategy.validate(dto);
        Selecao selecao = selecaoMapper.toEntity(dto);
        return selecaoMapper.toDTO(selecaoRepository.save(selecao));
    }

    @Override
    public SelecaoDTO buscarPorId(Long id) {
        Selecao selecao = selecaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seleção não encontrada com o id: " + id));
        return selecaoMapper.toDTO(selecao);
    }

    @Override
    public List<SelecaoDTO> listarTodos() {
        return selecaoRepository.findAll().stream()
                .map(selecaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SelecaoDTO atualizar(Long id, SelecaoDTO dto) {
        Selecao selecao = selecaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seleção não encontrada com o id: " + id));
        selecaoMapper.atualizarEntidade(dto, selecao);
        return selecaoMapper.toDTO(selecaoRepository.save(selecao));
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Selecao selecao = selecaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seleção não encontrada com o id: " + id));
        selecaoRepository.delete(selecao);
    }

}