package com.copa.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jogadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "numero_camisa", nullable = false)
    private Integer numeroCamisa;

    @Column(nullable = false)
    private String posicao;

    private Integer idade;

    // Relacionamento Um-Para-Muitos (Muitos jogadores para Uma seleção)
    @ManyToOne
    @JoinColumn(name = "selecao_id", nullable = false)
    private com.copa.api.entity.Selecao selecao;

}