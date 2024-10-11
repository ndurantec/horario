package com.gerentes.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerentes.horario.modelo.GradeDeHorario;

public interface GradeDeHorarioRepository extends JpaRepository<GradeDeHorario, Long> {
    
    @Query(value = "select * from grade_de_horario where nome like ?", nativeQuery = true)
    GradeDeHorario findByNome(String nome);


    @Query(value = "select * from disciplina where id_professor = ?", nativeQuery = true)
    GradeDeHorario findByNome(int id);
}
