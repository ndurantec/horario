package com.gerentes.horario.dto;

import com.gerentes.horario.modelo.Turma;

public class TurmaDto {
    private long id;
    private int capacidade;
    private String horario;
 
    @Deprecated
    public TurmaDto(){
    }

    public int getId() {
        return (int) id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }


    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Turma novaTurma(){
        return new Turma(null, capacidade, horario);
    }
}

 