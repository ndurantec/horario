package com.gerentes.horario.modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
    public class GradeDeHorario implements Serializable{

        private static final Long serialVersionUID =1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int diaDaSemana;
        private int posicaoDaAula;


        @OneToMany
        private List<Turma> turma;


        public static Long getSerialversionuid() {
            return serialVersionUID;
        }


        public int getDiaDaSemana() {
            return diaDaSemana;
        }


        public void setDiaDaSemana(int diaDaSemana) {
            this.diaDaSemana = diaDaSemana;
        }


        public int getPosicaoDaAula() {
            return posicaoDaAula;
        }


        public void setPosicaoDaAula(int posicaoDaAula) {
            this.posicaoDaAula = posicaoDaAula;
        }


        public List<Turma> getTurma() {
            return turma;
        }


        public void setTurma(List<Turma> turma) {
            this.turma = turma;
        }


        public GradeDeHorario(int diaDaSemana, int posicaoDaAula, List<Turma> turma) {
            this.diaDaSemana = diaDaSemana;
            this.posicaoDaAula = posicaoDaAula;
            this.turma = turma;
        }

        @Override
        public String toString() {
            return "GradeDeHorario [diaDaSemana=" + diaDaSemana + ", posicaoDaAula=" + posicaoDaAula + ", turma="
                    + turma + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + diaDaSemana;
            result = prime * result + posicaoDaAula;
            result = prime * result + ((turma == null) ? 0 : turma.hashCode());
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
            GradeDeHorario other = (GradeDeHorario) obj;
            if (diaDaSemana != other.diaDaSemana)
                return false;
            if (posicaoDaAula != other.posicaoDaAula)
                return false;
            if (turma == null) {
                if (other.turma != null)
                    return false;
            } else if (!turma.equals(other.turma))
                return false;
            return true;
    }
}