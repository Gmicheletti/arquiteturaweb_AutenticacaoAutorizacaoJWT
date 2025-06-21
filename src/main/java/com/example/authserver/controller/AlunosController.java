package com.example.authserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authserver.model.Alunos;
import com.example.authserver.service.AlunosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/alunos")
@Tag(name = "Alunos")
public class AlunosController {
    @Autowired
    private AlunosService alunosService;

    @Operation(summary = "Endpoint acessível apenas por usuários com a role 'ADMIN'")
    @PreAuthorize("hasRole('ADMIN')") // Exige que o JWT do usuário tenha a role 'ADMIN'
    @GetMapping
    public List<Alunos> getAll() {
        return alunosService.findAll();
    }

    @Operation(summary = "Endpoint acessível apenas por usuários com a role 'ADMIN'")
    @PreAuthorize("hasRole('ADMIN')") // Exige que o JWT do usuário tenha a role 'ADMIN'
    @PostMapping
    public Alunos create(@RequestBody Alunos aluno) {
        return alunosService.save(aluno);
    }

    @Operation(summary = "Endpoint acessível apenas por usuários com a role 'ADMIN'")
    @PreAuthorize("hasRole('ADMIN')") // Exige que o JWT do usuário tenha a role 'ADMIN'
    @GetMapping("/{id}")
    public ResponseEntity<Alunos> getAluno(@PathVariable Long id) {
        return alunosService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Endpoint acessível apenas por usuários com a role 'ADMIN'")
    @PreAuthorize("hasRole('ADMIN')") // Exige que o JWT do usuário tenha a role 'ADMIN'
    @PutMapping("/{id}")
    public ResponseEntity<Alunos> updateAluno(@PathVariable Long id, @RequestBody Alunos aluno) {
        return alunosService.update(id, aluno)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Endpoint acessível apenas por usuários com a role 'ADMIN'")
    @PreAuthorize("hasRole('ADMIN')") // Exige que o JWT do usuário tenha a role 'ADMIN'
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return alunosService.delete(id);
    }
}
