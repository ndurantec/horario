package com.gerentes.horario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gerentes.horario.dto.GradeDeHorarioDto;
import com.gerentes.horario.modelo.GradeDeHorario;

@RestController
public class GradeDeHorarioController {
    
    @GetMapping
    public String imprimir(){
        System.out.println("chegou aqui a requisição...");
        return "okok";
    }
    @PostMapping(value = "/api/gradedehorario/")
    public void create(@RequestBody GradeDeHorarioDto GradeDeHorarioDto){
        GradeDeHorario gradeDeHorario = GradeDeHorarioDto.novoGradeDeHorario();
        System.out.println(gradeDeHorario.toString());
    }
}