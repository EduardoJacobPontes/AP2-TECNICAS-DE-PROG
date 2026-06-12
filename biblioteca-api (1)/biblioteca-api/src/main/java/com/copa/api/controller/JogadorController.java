package com.copa.api.controller;

import com.copa.api.dto.JogadorDTO;
import com.copa.api.service.JogadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
@RequiredArgsConstructor
@Tag(name = "Jogadores", description = "Endpoints para gerenciamento de jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    @PostMapping
    @Operation(summary = "Cadastrar um novo jogador")
    public ResponseEntity<JogadorDTO> criar(@Valid @RequestBody JogadorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorService.criar(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar jogador pelo ID")
    public ResponseEntity<JogadorDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(jogadorService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar todos os jogadores")
    public ResponseEntity<List<JogadorDTO>> listarTodos() {
        return ResponseEntity.ok(jogadorService.listarTodos());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um jogador existente")
    public ResponseEntity<JogadorDTO> atualizar(@PathVariable Long id, @Valid @RequestBody JogadorDTO dto) {
        return ResponseEntity.ok(jogadorService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover um jogador")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        jogadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}