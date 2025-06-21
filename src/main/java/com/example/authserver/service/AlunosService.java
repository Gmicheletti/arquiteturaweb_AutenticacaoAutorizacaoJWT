package com.example.authserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.authserver.model.Alunos;
import com.example.authserver.repository.AlunosRepository;

@Service
public class AlunosService {
    @Autowired
    private AlunosRepository alunoRepository;

    public List<Alunos> findAll(){
        return alunoRepository.findAll();
    }

    public Alunos save(Alunos aluno){
        return alunoRepository.save(aluno);
    }

    public Optional<Alunos> findById(Long id){
        return alunoRepository.findById(id);
    }

    public Optional<Alunos> update(Long id, Alunos updateAluno){
        return alunoRepository.findById(id).map(existingModel ->{
            existingModel.setNome(updateAluno.getNome());
            existingModel.setEmail(updateAluno.getEmail());
            existingModel.setDataNascimento(updateAluno.getDataNascimento());

            return alunoRepository.save(existingModel);
        });
    }

    public ResponseEntity<Void> delete(Long id){
        if(alunoRepository.existsById(id)){
            alunoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
