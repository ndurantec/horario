package com.gerentes.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerentes.horario.modelo.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
}
