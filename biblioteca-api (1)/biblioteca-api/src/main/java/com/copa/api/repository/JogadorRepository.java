package com.copa.api.repository;

import com.copa.api.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    // O JpaRepository já traz todos os métodos CRUD básicos (save, findById, findAll, delete)

}