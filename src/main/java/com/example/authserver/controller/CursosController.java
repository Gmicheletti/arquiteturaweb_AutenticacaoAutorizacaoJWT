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

import com.example.authserver.model.Cursos;
import com.example.authserver.service.CursosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cursos")
@Tag(name = "Cursos")
public class CursosController {
    @Autowired
    private CursosService cursosService;

    @Operation(summary = "Endpoint acessível apenas por usuários com a role 'USER'")
    @PreAuthorize("hasRole('USER')") // Exige que o JWT do usuário tenha a role 'ADMIN'
    @GetMapping
    public List<Cursos> getAll() {
        return cursosService.findAll();
    }

    @Operation(summary = "Endpoint acessível apenas por usuários com a role 'USER'")
    @PreAuthorize("hasRole('USER')") // Exige que o JWT do usuário tenha a role 'ADMIN'
    @PostMapping
    public Cursos create(@RequestBody Cursos curso) {
        return cursosService.save(curso);
    }

    @Operation(summary = "Endpoint acessível apenas por usuários com a role 'USER'")
    @PreAuthorize("hasRole('USER')") // Exige que o JWT do usuário tenha a role 'ADMIN'
    @GetMapping("/{id}")
    public ResponseEntity<Cursos> getCurso(@PathVariable Long id) {
        return cursosService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Endpoint acessível apenas por usuários com a role 'USER'")
    @PreAuthorize("hasRole('USER')") // Exige que o JWT do usuário tenha a role 'ADMIN'
    @PutMapping("/{id}")
    public ResponseEntity<Cursos> updateCurso(@PathVariable Long id, @RequestBody Cursos curso) {
        return cursosService.update(id, curso)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Endpoint acessível apenas por usuários com a role 'USER'")
    @PreAuthorize("hasRole('USER')") // Exige que o JWT do usuário tenha a role 'ADMIN'
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return cursosService.delete(id);
    }
}
