package com.copa.api.strategy;

import com.copa.api.dto.JogadorDTO;
import org.springframework.stereotype.Component;

@Component
public class JogadorValidationStrategy implements ValidationStrategy<JogadorDTO> {

    @Override
    public void validate(JogadorDTO dto) {
        // Regra de negócio isolada usando Strategy
        if (dto.getIdade() != null && dto.getIdade() < 15) {
            throw new IllegalArgumentException("Operação não permitida: O jogador deve ter pelo menos 15 anos para participar da Copa.");
        }
    }

}