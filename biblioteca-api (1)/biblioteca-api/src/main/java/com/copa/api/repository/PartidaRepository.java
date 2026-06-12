package com.copa.api.repository;

import com.copa.api.entity.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

    // O JpaRepository já traz todos os métodos CRUD básicos (save, findById, findAll, delete)

}