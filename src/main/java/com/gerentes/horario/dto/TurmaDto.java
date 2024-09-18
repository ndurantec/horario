package com.gerentes.horario.dto;

import com.gerentes.horario.modelo.Turma;

public class TurmaDto {
    private long id;
    private String nome;
    private int sala;
 
    @Deprecated
    public TurmaDto(){
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



            public int getSala() {
                return sala;
            }


            public void setSala(int sala) {
                this.sala = sala;
            }

        public Turma novaTurma(){
            return new Turma(null, nome, sala);
        }
}

 