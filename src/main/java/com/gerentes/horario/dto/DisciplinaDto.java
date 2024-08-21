package com.gerentes.horario.dto;

import com.gerentes.horario.modelo.Disciplina;
import com.gerentes.horario.modelo.Professor;

public class DisciplinaDto {
    private String nome;
    private int cargaHoraria;
    private Professor professor;

    @Deprecated
    public DisciplinaDto() {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'novoDisciplina'");
    }
}
