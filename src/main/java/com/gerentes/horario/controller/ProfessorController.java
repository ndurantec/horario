package com.gerentes.horario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerentes.horario.modelo.Professor;
import com.gerentes.horario.dto.ProfessorDto;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {
    
    @GetMapping (value = "/imprimir")
    public String imprimir() {
        System.out.println("Chegou aqui a requisição...");
        return "okok";
    }

    @PostMapping("/create")
    public String create(@RequestBody ProfessorDto professorDto) {
        try {
            Professor professor = professorDto.novoProfessor();
            System.out.println(professor.toString());
            return "Professor criado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao criar professor.";
        }
    }
}
