package com.gerentes.horario.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerentes.horario.modelo.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{

    Optional<Turma> findByNome(String nome);

    /*
    @Query(value = "select * from turma where nome like ?", nativeQuery = true)
    Turma findByNome(String nome);
    */
    //@Transactional(readOnly = true)  
    @Query(value = "select u.id from conta u where u.turma = ?1", nativeQuery = true)
    Long findByIdNome(String turma);

    boolean existsByNome(String nome);

    @Query(value = "select * from turma where sala = ?1", nativeQuery = true)
    Turma findBySala(int sala);

}