package com.copa.api.service;

import com.copa.api.dto.JogadorDTO;
import java.util.List;

public interface JogadorService {

    JogadorDTO criar(JogadorDTO dto);

    JogadorDTO buscarPorId(Long id);

    List<JogadorDTO> listarTodos();

    JogadorDTO atualizar(Long id, JogadorDTO dto);

    void deletar(Long id);

}