package com.gerentes.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerentes.horario.modelo.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

    @Query(value = "select * from disciplina where nome like ?", nativeQuery = true)
    Disciplina findByNome(String nome);

<<<<<<< HEAD
    @Query(value = "select * from disciplina d inner join professor p on d.id_professor = p.id;", nativeQuery = true)
    Disciplina findByProfessor(Long id);
=======
>>>>>>> b9ccce06a92a0f08e327788a5c55df1e0e928c3a
}
