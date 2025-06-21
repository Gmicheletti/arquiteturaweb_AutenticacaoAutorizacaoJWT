package com.example.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authserver.model.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long>{
    
}
