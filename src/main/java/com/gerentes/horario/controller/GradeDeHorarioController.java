package com.gerentes.horario.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerentes.horario.modelo.GradeDeHorario;
import com.gerentes.horario.dto.GradeDeHorarioDto;

@RestController
@RequestMapping(value = "/grade")
public class GradeDeHorarioController {
    
    @GetMapping(value = "/imprimir")
    public String imprimir() {
        System.out.println("Chegou aqui a requisição...");
        return "okok";
    }

    @PostMapping("/create")
    public String create(@RequestBody GradeDeHorarioDto gradeDeHorarioDto) {
        try {
            GradeDeHorario gradeDeHorario = gradeDeHorarioDto.novoGradeDeHorario();
            System.out.println(gradeDeHorario.toString());
            return "Grade de Horário criada com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao criar grade de horário.";
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
