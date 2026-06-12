package com.copa.api.service;

import com.copa.api.dto.PartidaDTO;
import java.util.List;

public interface PartidaService {

    PartidaDTO criar(PartidaDTO dto);

    PartidaDTO buscarPorId(Long id);

    List<PartidaDTO> listarTodos();

    PartidaDTO atualizar(Long id, PartidaDTO dto);

    void deletar(Long id);

}