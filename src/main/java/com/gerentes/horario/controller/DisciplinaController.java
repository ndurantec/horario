package com.gerentes.horario.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    /*
    @PostMapping
    public Disciplina createDisciplina(@RequestBody Disciplina disciplina) {
        Object disciplinaService;
        return disciplinaService.save(disciplina);
    }
     @PutMapping("/{id}")
    public ResponseEntity<Disciplina> updateDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        if (disciplina.findById(id).isPresent()) {
            disciplina.setId(id);
            return ResponseEntity.ok(disciplinaService.save(disciplina));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplina(@PathVariable Long id) {
        if (disciplinaService.findById(id).isPresent()) {
            disciplinaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }*/

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
