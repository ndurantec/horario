package com.gerentes.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerentes.horario.modelo.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{

    @Query(value = "select * from turma where nome like ?", nativeQuery = true)
    Turma findByNome(String nome);

}