package com.gerentes.horario.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping(value = "/criar")
    public String criar(){
        System.out.println("Chegou aqui a requisição...");
        return "criado";
    } 

    @DeleteMapping(value = "/deletar")
    public String deletar(){
        System.out.println("Chegou aqui a requisição...");
        return "deletado";
    }

    @GetMapping(value = "/consultar")
    public String consultar(){
        System.out.println("Chegou aqui a requisição...");
        return "consultado";
    }

    @PutMapping(value = "/alterar")
    public String alterar(){
        System.out.println("Chegou aqui a requisição...");
        return "alterado";
    
    }
}