package com.example.authserver.model;

import java.sql.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan("com.example.authserver.model")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Cursos curso;
}
