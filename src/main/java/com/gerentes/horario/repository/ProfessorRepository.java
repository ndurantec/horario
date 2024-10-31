package com.gerentes.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.gerentes.horario.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

    @Query(value = "select * from professor where nome like ?", nativeQuery = true)
    Professor findByNome(String nome);

    
    @Query(value = "select * from professor where cpf = ?1", nativeQuery = true)
    Professor findByCpf(String cpf);
    
}
