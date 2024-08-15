package com.gerentes.horario.dto;

import com.gerentes.horario.modelo.Professor;

public class ProfessorDto {
    private String nome;
    private String cpf;
 
    @Deprecated
    public ProfessorDto(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public Professor novoProfessor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'novoProfessor'");
    }
}