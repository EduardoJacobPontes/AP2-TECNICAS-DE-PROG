package com.copa.api.strategy;

import com.copa.api.dto.SelecaoDTO;
import com.copa.api.repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SelecaoValidationStrategy implements ValidationStrategy<SelecaoDTO> {

    private final SelecaoRepository selecaoRepository;

    @Override
    public void validate(SelecaoDTO dto) {
        if (selecaoRepository.existsByNomePais(dto.getNomePais())) {
            throw new IllegalArgumentException("Já existe uma seleção cadastrada com o nome: " + dto.getNomePais());
        }
    }

}