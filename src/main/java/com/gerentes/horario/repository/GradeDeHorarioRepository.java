package com.gerentes.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerentes.horario.modelo.GradeDeHorario;

public interface GradeDeHorarioRepository extends JpaRepository<GradeDeHorario, Long> {
    
}
