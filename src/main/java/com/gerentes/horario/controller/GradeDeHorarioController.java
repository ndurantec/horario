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

import com.gerentes.horario.modelo.GradeDeHorario;
import com.gerentes.horario.repository.GradeDeHorarioRepository;
import com.gerentes.horario.dto.GradeDeHorarioDto;


@RestController
@RequestMapping(value = "/grade")
 public class GradeDeHorarioController {
    
    @Autowired
    private GradeDeHorarioRepository gradeDeHorarioRepository;

    //Criar
    @CrossOrigin("*")
        @PostMapping(value = "/insert")
        public ResponseEntity<GradeDeHorario> insert(GradeDeHorarioDto gradeDeHorarioDto){
            GradeDeHorario gradeDeHorario = gradeDeHorarioDto.novoGradeDeHorario();
            gradeDeHorarioRepository.save(gradeDeHorario);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/[id]").buildAndExpand(gradeDeHorario.getPosicaoDaAula()).toUri();

        return ResponseEntity.created(uri).body(gradeDeHorario);
        }

    @GetMapping(value = "/findAll")
    public List<GradeDeHorario> findAll (){
    
          return gradeDeHorarioRepository.findAll();
    }
    
    //Consultar
    @GetMapping(value = "/{id}")
    public ResponseEntity<GradeDeHorario> findById(@PathVariable Long id){
        return gradeDeHorarioRepository.findById(id)
                .map(registro -> ResponseEntity.ok().body(registro))
                        .orElse(ResponseEntity.notFound().build());

    }

    //Atualizar
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody GradeDeHorario gradeDeHorario){
       Optional<GradeDeHorario> gradeDeHorarioBanco = gradeDeHorarioRepository.findById(id);

        GradeDeHorario gradeDeHorarioModificado = gradeDeHorarioBanco.get();
            gradeDeHorarioModificado.setDiaDaSemana(gradeDeHorario.getDiaDaSemana());
              gradeDeHorarioRepository.save(gradeDeHorarioModificado);

              
        return ResponseEntity.noContent().build();
    }

    //Deletar
   @DeleteMapping(value = "/{id}")
   public ResponseEntity<Void> deletar(@PathVariable Long id){
       gradeDeHorarioRepository.deleteById(id);

       
       return ResponseEntity.noContent().build();
   }
 }

