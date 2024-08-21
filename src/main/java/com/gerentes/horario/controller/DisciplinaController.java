package com.gerentes.horario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerentes.horario.modelo.Disciplina;
import com.gerentes.horario.dto.DisciplinaDto;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {
    
    @GetMapping(value ="/imprimir")
    public String imprimir() {
        System.out.println("Chegou aqui a requisição...");
        return "okok";
    }

    @PostMapping("/create")
    public String create(@RequestBody DisciplinaDto disciplinaDto) {
        try {
            Disciplina disciplina = disciplinaDto.novoDisciplina();
            System.out.println(disciplina.toString());
            return "Disciplina criada com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao criar disciplina.";
        }
    }
}
