package com.copa.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "partidas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private String estadio;

    @Column(name = "fase_competicao", nullable = false)
    private String faseCompeticao;

    private String placar;

    // Relacionamento Muitos-para-Muitos (Muitas seleções para Muitas partidas)
    @ManyToMany
    @JoinTable(
            name = "partida_selecao",
            joinColumns = @JoinColumn(name = "partida_id"),
            inverseJoinColumns = @JoinColumn(name = "selecao_id")
    )
    private List<com.copa.api.entity.Selecao> selecoes;

}