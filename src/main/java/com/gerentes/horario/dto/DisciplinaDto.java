package com.gerentes.horario.dto;

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

    public DisciplinaDto(String nome, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
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
        return new Disciplina(nome, cargaHoraria, professor);
    }

    @Override
    public String toString() {
        return "DisciplinaDto [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + ", professor="
                + professor + "]";
    }


    
    
}
