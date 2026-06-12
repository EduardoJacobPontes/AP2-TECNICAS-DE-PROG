package com.copa.api.controller;

import com.copa.api.dto.PartidaDTO;
import com.copa.api.service.PartidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidas")
@RequiredArgsConstructor
@Tag(name = "Partidas", description = "Endpoints para gerenciamento de partidas")
public class PartidaController {

    private final PartidaService partidaService;

    @PostMapping
    @Operation(summary = "Cadastrar uma nova partida")
    public ResponseEntity<PartidaDTO> criar(@Valid @RequestBody PartidaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(partidaService.criar(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar partida pelo ID")
    public ResponseEntity<PartidaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(partidaService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar todas as partidas")
    public ResponseEntity<List<PartidaDTO>> listarTodos() {
        return ResponseEntity.ok(partidaService.listarTodos());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma partida existente")
    public ResponseEntity<PartidaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PartidaDTO dto) {
        return ResponseEntity.ok(partidaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma partida")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        partidaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}