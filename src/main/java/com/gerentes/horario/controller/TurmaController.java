package com.gerentes.horario.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerentes.horario.modelo.Turma;
import com.gerentes.horario.dto.TurmaDto;


@RestController
@RequestMapping(value = "/turma")
public class TurmaController {
    
    @GetMapping (value = "/imprimir")
    public String imprimir(){
        System.out.println("chegou aqui a requisição...");
        return "okok";
    }
    
    @PostMapping("/create")
    public String create(@RequestBody TurmaDto turmaDto) {
        try {
            Turma turma = turmaDto.novaTurma();
            System.out.println(turma.toString());
            return "Turma criada com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao criar turma.";
        }
    }

    
}