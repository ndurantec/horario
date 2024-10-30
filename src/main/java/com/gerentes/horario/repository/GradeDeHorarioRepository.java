package com.gerentes.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerentes.horario.modelo.GradeDeHorario;

public interface GradeDeHorarioRepository extends JpaRepository<GradeDeHorario, Long> {
<<<<<<< HEAD
    @Query(value = "select * from grade_de_horario wehre nome like = ?", nativeQuery = true)
    GradeDeHorario findByNome(String nome);

    @Query(value = "select * from disciplina wehre id_professor = ?", nativeQuery = true)
=======
    
    @Query(value = "select * from grade_de_horario where nome like ?", nativeQuery = true)
    GradeDeHorario findByNome(String nome);


    @Query(value = "select * from disciplina where id_professor = ?", nativeQuery = true)
>>>>>>> b9ccce06a92a0f08e327788a5c55df1e0e928c3a
    GradeDeHorario findByNome(int id);
}
