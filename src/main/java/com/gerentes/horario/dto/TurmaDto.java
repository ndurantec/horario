package com.gerentes.horario.dto;

import com.gerentes.horario.modelo.Turma;

public class TurmaDto {
    private int id;
    private int capacidade;
    private int horario;
 
@Deprecated
public TurmaDto(){
}

public int getId() {
    return id;
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


public int getHorario() {
    return horario;
}

public void setHorario(int horario) {
    this.horario = horario;
}

public Turma novoTurma() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'novoTurma'");
}
}