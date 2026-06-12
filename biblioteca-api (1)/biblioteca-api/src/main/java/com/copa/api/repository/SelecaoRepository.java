package com.copa.api.repository;

import com.copa.api.entity.Selecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelecaoRepository extends JpaRepository<Selecao, Long> {

    // Método customizado para validar se já existe uma seleção com esse nome
    boolean existsByNomePais(String nomePais);

}