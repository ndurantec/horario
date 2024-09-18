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
        private String nome;
        private int sala;

        @Deprecated
        public Turma() {
        }

            public static long getSerialversionuid() {
                return serialVersionUID;
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

            public int getSala() {
                return sala;
            }

            public void setSala(int sala) {
                this.sala = sala;
            }

            public Turma(Long id, String nome, int sala) {
                this.id = id;
                this.nome = nome;
                this.sala = sala;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((id == null) ? 0 : id.hashCode());
                result = prime * result + ((nome == null) ? 0 : nome.hashCode());
                result = prime * result + sala;
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
                if (id == null) {
                    if (other.id != null)
                        return false;
                } else if (!id.equals(other.id))
                    return false;
                if (nome == null) {
                    if (other.nome != null)
                        return false;
                } else if (!nome.equals(other.nome))
                    return false;
                if (sala != other.sala)
                    return false;
                return true;
            }

            @Override
            public String toString() {
                return "Turma [id=" + id + ", nome=" + nome + ", sala=" + sala + "]";
            }

            
    }
    
