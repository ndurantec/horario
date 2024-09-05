package com.gerentes.horario.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerentes.horario.modelo.Disciplina;
import com.gerentes.horario.modelo.Turma;
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
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable long id){
        return disciplinaRepository.findById(id)
            .map(registro -> ResponseEntity.ok().body(registro))
                    .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Disciplina disciplina){

       Optional<Disciplina> disciplinaBanco = disciplinaRepository.findById(id);

        Disciplina disciplinaModificado = disciplinaBanco.get();

        disciplinaModificado.setNome(disciplina.getNome());

        disciplinaRepository.save(disciplinaModificado);

        return ResponseEntity.noContent().build();
    }

     //Deletar
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Optional<Disciplina> disciplinaBanco = disciplinaRepository.findById(id);

        disciplinaRepository.deleteById(id);
            
        return ResponseEntity.noContent().build();  
    }
}