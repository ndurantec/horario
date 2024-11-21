package com.gerentes.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerentes.horario.modelo.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

    @Query(value = "select * from disciplina where nome like ?", nativeQuery = true)
    Disciplina findByNome(String nome);


    @Query(value = "select * from disciplina d inner join professor p on d.id_professor = p.id;", nativeQuery = true)
    Disciplina findByProfessor(Long id);

    @Query(value = "select count(*) from disciplina where nome = ? and id_professor = ?;", nativeQuery = true)
    Long duplicadoDisciplinaPorProfessor(String nome, Long id);

}
