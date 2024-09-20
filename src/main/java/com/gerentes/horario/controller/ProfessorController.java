package com.gerentes.horario.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerentes.horario.dto.ProfessorDto;
import com.gerentes.horario.modelo.Professor;
import com.gerentes.horario.repository.ProfessorRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;
     
    
    //Vizualizar todos
    @GetMapping(value = "/findAll")
    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    //Criar
    @PostMapping (value = "/insert")
    public ResponseEntity<Professor> insert(@RequestBody ProfessorDto professorDto) {

        Professor professor = professorDto.novoProfessor();
        professorRepository.save(professor);

        System.out.println("Chegou no método insert");
        System.out.println(professorDto.toString());

        professor.setNome(professorDto.getNome());
        professor.setCpf(professorDto.getCpf());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/id").buildAndExpand(professor.getId()).toUri();
        
        return ResponseEntity.created(uri).body(professor);
    }

   //Consultar
    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        System.out.println("chegou no método findById");
        return professorRepository.findById(id)
            .map(registro -> ResponseEntity.ok().body(registro))
            .orElse(ResponseEntity.notFound().build());
    }
           
    //Atualizar
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Professor professor) {

       Optional<Professor> professorBanco = professorRepository.findById(id);

       Professor professorModificado = professorBanco.get();

       professorModificado.setNome(professor.getNome());
       professorModificado.setCpf(professor.getCpf());

       professorRepository.save(professorModificado);

       return ResponseEntity.noContent().build();
    }
    
    //Deletar
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        System.out.println("Chegou no servidor");
        professorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
