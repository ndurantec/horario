package com.gerentes.horario.dto;

import com.gerentes.horario.modelo.Professor;

public class ProfessorDto {
    private Long id;
    private String nome;
    private String cpf;
 
    @Deprecated
    public ProfessorDto(){
    }

    
    
    public ProfessorDto(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }



    public Professor novoProfessor() {
        return new Professor(null, nome, cpf);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}