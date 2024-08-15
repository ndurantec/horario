package com.gerentes.horario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gerentes.horario.dto.ProfessorDto;
import com.gerentes.horario.modelo.Professor;

@RestController
public class ProfessorController {
    
    @GetMapping
    public String imprimir(){
        System.out.println("chegou aqui a requisição...");
        return "okok";
    }
    @PostMapping(value = "/api/professor/")
    public void create(@RequestBody ProfessorDto ProfessorDto){
        Professor professor = ProfessorDto.novoProfessor();
        System.out.println(professor.toString());
    }
}