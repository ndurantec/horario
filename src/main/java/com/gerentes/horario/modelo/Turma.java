package com.gerentes.horario.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Turma implements Serializable{

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    int capacidade;
    int horario;

    @Deprecated
    public Turma() {
    }

    
      
    public Long getId() {
        return id;
    }
    
    
    public void setId(int id) {
        this.id = (long) id;
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
    
    
    public Turma(int id, int capacidade, int horario) {
        this.id = (long) id;
        this.capacidade = capacidade;
        this.horario = horario;
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + id);
        result = prime * result + capacidade;
        result = prime * result + horario;
        return result;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Turma other = (Turma) obj;
        if (id != other.id)
            return false;
        if (capacidade != other.capacidade)
            return false;
        if (horario != other.horario)
            return false;
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Turma [id=" + id + ", capacidade=" + capacidade + ", horario=" + horario + "]";
    }
    }
    
