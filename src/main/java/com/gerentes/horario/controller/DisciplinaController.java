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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerentes.horario.modelo.Disciplina;
import com.gerentes.horario.modelo.Turma;
import com.gerentes.horario.repository.DisciplinaRepository;
import com.gerentes.horario.dto.DisciplinaDto;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/disciplina")
public class DisciplinaController {
 
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    //Vizualizar Todos
    @GetMapping(value = "/findAll")
    public List<Disciplina> findAll(){
        return disciplinaRepository.findAll();
    }

    //Criar
    @PostMapping(value = "/insert")
    public ResponseEntity<?> insert(@RequestBody DisciplinaDto disciplinaDto){
       
        System.out.println("====================================");
        System.out.println("====================================");
        System.out.println("====================================");
        System.out.println(disciplinaDto.toString());
        System.out.println("====================================");
        System.out.println("====================================");
        System.out.println("====================================");
       
        Long quantidade = disciplinaRepository.duplicadoDisciplinaPorProfessor(disciplinaDto.getNome(), disciplinaDto.getProfessor().getId());

        if (quantidade >= 1) {
            
            return ResponseEntity.ok("Professor repetido, na mesma disciplina");
        } 
       
        Disciplina disciplina = disciplinaDto.novoDisciplina();
        
        // String resultado = validadorCargaHoraria(disciplina);

        if (  !validadorCargaHoraria(disciplinaDto).equals("true")   ) {
            return ResponseEntity.ok().body("A carga horária da disciplina não pode ser maior que 6");
        }

        
        // if (!resultado.equals("true")) {
        //     return ResponseEntity.ok().body("A carga horária da disciplina não pode ser maior que 6");
        // }

        disciplinaRepository.save(disciplina);

        System.out.println("Chamou o método insert");
        System.out.println(disciplinaDto.toString());

        disciplina.setNome(disciplinaDto.getNome());
        disciplina.setCargaHoraria(disciplina.getCargaHoraria());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
                .buildAndExpand(disciplina.getId())
                    .toUri();

        return ResponseEntity.created(uri).body(disciplina);
    }
    
    /* 
    //Consultar
    @GetMapping(value = "/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable long id){
        return disciplinaRepository.findById(id)
            .map(registro -> ResponseEntity.ok().body(registro))
                    .orElse(ResponseEntity.notFound().build());
    }
    */


    /* 
    //Restrição
    @GetMapping(value = "/{id}")
    public findByProfessor(){

    };
    */

    //Consultar
    @GetMapping(value = "/consultarDisciplinaPorNome")
    public ResponseEntity<DisciplinaDto>consultarPorNome(@RequestParam String nome) {
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("O nome ---> " + nome);
        Disciplina disciplinaConsultado = disciplinaRepository.findByNome(nome);
        DisciplinaDto disciplinaDTO = new DisciplinaDto(disciplinaConsultado.getNome(), disciplinaConsultado.getCargaHoraria(), disciplinaConsultado.getProfessor());

        return ResponseEntity.ok().body(disciplinaDTO);
    }


    //Atualizar
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody DisciplinaDto disciplinaDto){


        if ( !validadorCargaHoraria(disciplinaDto).equals("true") ) {
            return ResponseEntity.ok( "A carga horária da disciplina não pode ser maior que 6");

        }


        
       Optional<Disciplina> disciplinaBanco = disciplinaRepository.findById(id);

       if (!disciplinaBanco.isPresent()){
         return ResponseEntity.notFound().build();
       }

        Disciplina disciplinaModificado = disciplinaBanco.get();
        
        disciplinaModificado.setNome(disciplinaDto.getNome());
        disciplinaModificado.setCargaHoraria(disciplinaDto.getCargaHoraria());
        disciplinaModificado.setProfessor(disciplinaDto.getProfessor());


        disciplinaRepository.save(disciplinaModificado);


        return ResponseEntity.noContent().build();
    }


    private String validadorCargaHoraria(DisciplinaDto disciplinaDto) {

            if (disciplinaDto.getCargaHoraria() <= 6 ) {                
                return "true";
            }
            
            return "A carga horária da disciplina não pode ser maior que 6";          
    }  

    

     //Deletar
     @DeleteMapping(value = "/{id}")
     public ResponseEntity<Void> deletar(@PathVariable Long id){
 
         System.out.println("Chegou no servidor");
            disciplinaRepository.deleteById(id);
                 return ResponseEntity.noContent().build();
    }
 }