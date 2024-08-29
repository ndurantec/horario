package com.gerentes.horario.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerentes.horario.modelo.Disciplina;
import com.gerentes.horario.repository.DisciplinaRepository;
import com.gerentes.horario.dto.DisciplinaDto;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    
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

    //primeira versão do codigo
    @GetMapping(value = "/findAll")
    public List findAll(){
        return disciplinaRepository.findAll();
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Disciplina> insert(@RequestBody DisciplinaDto disciplinaDto){

        Disciplina disciplina = disciplinaDto.novoDisciplina();
        disciplinaRepository.save(disciplina);

       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(disciplina.getId())
                    .toUri();

        return ResponseEntity.created(uri).body(disciplina);
    }
}