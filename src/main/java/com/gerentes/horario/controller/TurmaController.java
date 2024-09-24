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

import com.gerentes.horario.modelo.Turma;
import com.gerentes.horario.repository.TurmaRepository;
import com.gerentes.horario.dto.TurmaDto;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "/turma")
public class TurmaController {



    @Autowired
    private TurmaRepository turmaRepository;


    //Vizualizar todos
    @GetMapping(value = "/findAll")
    public List<Turma> findAll(){
        return turmaRepository.findAll();
    }

    //Criar
    @PostMapping(value = "/insert")
    public ResponseEntity<Turma> insert(@RequestBody TurmaDto turmaDto){
        Turma turma = turmaDto.novaTurma();
        

        System.out.println("Chegou no método insert");
        System.out.println(turmaDto.toString());

        turma.setNome(turmaDto.getNome());
        turma.setSala(turmaDto.getSala());

        turmaRepository.save(turma);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/[id]").buildAndExpand(turma.getId()).toUri();


        return ResponseEntity.created(uri).body(turma);
        
    }

    


    //Consultar
    @GetMapping(value = "/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Long id){
        System.out.println("chegou no método findById");
        return turmaRepository.findById(id)

                .map(registro -> ResponseEntity.ok().body(registro))
                        .orElse(ResponseEntity.notFound().build());

    }

    //Atualizar
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Turma turma){
    Optional<Turma> turmaBanco = turmaRepository.findById(id);

        Turma turmaModificado = turmaBanco.get();
            turmaModificado.setNome(turma.getNome());
            turmaModificado.setSala(turma.getSala());

                turmaRepository.save(turmaModificado);

        return ResponseEntity.noContent().build();

    }

    //Deletar
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

        System.out.println("Chegou no servidor");
        turmaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}