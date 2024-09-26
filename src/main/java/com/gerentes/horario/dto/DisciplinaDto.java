package com.gerentes.horario.dto;

import java.util.List;

import com.gerentes.horario.modelo.Disciplina;
import com.gerentes.horario.modelo.Professor;

public class DisciplinaDto {
    private long id;
    private String nome;
    private int cargaHoraria;
    private Professor professor;

    @Deprecated
    public DisciplinaDto() {
    }

    public DisciplinaDto(Long id, String nome, int cargaHoraria, List<Professor> professor){
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = (Professor) professor;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getCargaHoraria() {
        return cargaHoraria;
    }


    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }


    public Professor getProfessor() {
        return professor;
    }


    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina novoDisciplina() {
        return new Disciplina(nome, cargaHoraria, null);
       }
}
