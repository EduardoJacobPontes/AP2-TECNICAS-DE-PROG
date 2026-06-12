package com.copa.api.controller;

import com.copa.api.dto.SelecaoDTO;
import com.copa.api.service.SelecaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/selecoes")
@RequiredArgsConstructor
@Tag(name = "Seleções", description = "Endpoints para gerenciamento de seleções")
public class SelecaoController {

    private final SelecaoService selecaoService;

    @PostMapping
    @Operation(summary = "Cadastrar uma nova seleção")
    public ResponseEntity<SelecaoDTO> criar(@Valid @RequestBody SelecaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(selecaoService.criar(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar seleção pelo ID")
    public ResponseEntity<SelecaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(selecaoService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar todas as seleções")
    public ResponseEntity<List<SelecaoDTO>> listarTodos() {
        return ResponseEntity.ok(selecaoService.listarTodos());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma seleção existente")
    public ResponseEntity<SelecaoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody SelecaoDTO dto) {
        return ResponseEntity.ok(selecaoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma seleção")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        selecaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}