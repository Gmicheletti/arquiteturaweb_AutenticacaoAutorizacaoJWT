package com.example.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authserver.model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long>{}