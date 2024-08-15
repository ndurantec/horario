package com.gerentes.horario.dto;

import com.gerentes.horario.modelo.GradeDeHorario;
import com.gerentes.horario.modelo.Turma;

public class GradeDeHorarioDto {

    private int diaDaSemana;
    private int posicaoDaAula;
    private Turma turma;

    @Deprecated
    public GradeDeHorarioDto() {
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

    public Turma getTurma() {
        return turma;
    }
    
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public GradeDeHorario novoGradeDeHorario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'novoGradeDeHorario'");
    }
}
