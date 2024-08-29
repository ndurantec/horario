package com.gerentes.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gerentes.horario.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

    
    
}
