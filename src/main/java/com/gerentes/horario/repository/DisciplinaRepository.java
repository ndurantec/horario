package com.gerentes.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerentes.horario.modelo.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

    @Query(value = "select * from disciplina where nome like ?", nativeQuery = true)
    Disciplina findByNome(String nome);

}
