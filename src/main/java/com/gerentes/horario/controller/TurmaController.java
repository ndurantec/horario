package com.gerentes.horario.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gerentes.horario.modelo.Turma;
import com.gerentes.horario.dto.TurmaDto;


@RestController
public class TurmaController {
    



    @GetMapping
    public String imprimir(){
        System.out.println("chegou aqui a requisição...");
        return "okok";
    }
    @PostMapping(value = "/api/professor/")
    public void create(@RequestBody TurmaDto TurmaDto){
        Turma turma = TurmaDto.novoTurma();
        System.out.println(turma.toString());
    }
}