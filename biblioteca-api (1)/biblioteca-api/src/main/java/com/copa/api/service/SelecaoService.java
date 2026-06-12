package com.copa.api.service;

import com.copa.api.dto.SelecaoDTO;
import java.util.List;

public interface SelecaoService {

    SelecaoDTO criar(SelecaoDTO dto);

    SelecaoDTO buscarPorId(Long id);

    List<SelecaoDTO> listarTodos();

    SelecaoDTO atualizar(Long id, SelecaoDTO dto);

    void deletar(Long id);

}