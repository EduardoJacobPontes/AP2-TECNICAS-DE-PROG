package com.copa.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "selecoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Selecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_pais", nullable = false, unique = true)
    private String nomePais;

    @Column(nullable = false)
    private String tecnico;

    @Column(name = "ranking_fifa")
    private Integer rankingFifa;

}