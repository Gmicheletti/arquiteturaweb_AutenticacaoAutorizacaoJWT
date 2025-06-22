package com.example.authserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.authserver.controller.AlunosController;
import com.example.authserver.model.Alunos;
import com.example.authserver.model.Cursos;
import com.example.authserver.service.AlunosService;

@SpringBootTest
public class AlunosTest {

    @InjectMocks
    private AlunosController AlunosController;

    @Mock
    private AlunosService AlunosService;

    List<Alunos> AlunossList = new ArrayList<>();

    @Test
    @BeforeEach
    void test_insert() {
        Alunos newAlunos = new Alunos(
                null,
                "Alunos1",
                "email@email.com",
                Date.valueOf("1994-09-18"),
                new Cursos(1L, null, null, null) // Passe o objeto Cursos com o id desejado
        );
        when(AlunosService.save(newAlunos)).thenReturn(newAlunos);

        Alunos result = AlunosController.create(newAlunos);

        assertEquals(newAlunos, result);

        AlunossList.add(newAlunos);
    }

    @Test
    void test_getAll() {
        when(AlunosService.findAll()).thenReturn(AlunossList);

        List<Alunos> response = AlunosController.getAll();

        assertEquals(1, response.size());
        verify(AlunosService, times(1)).findAll();
    }

    @Test
    void test_update() {

        Alunos existingAlunos = AlunossList.get(0);
        Long AlunosID = existingAlunos.getId();

        Alunos updatedAlunos = new Alunos(
                AlunosID,
                "Alunos1",
                "email@email.com",
                Date.valueOf("1994-09-18"),
                new Cursos(1L, null, null, null) // Passe o objeto Cursos com o id desejado
        );
        when(AlunosService.findById(AlunosID)).thenReturn(Optional.of(existingAlunos));
        when(AlunosService.update(AlunosID, updatedAlunos)).thenReturn(Optional.of(updatedAlunos));

        ResponseEntity<Alunos> response = AlunosController.updateAluno(AlunosID, updatedAlunos);

        assertEquals(ResponseEntity.ok(updatedAlunos), response);
        verify(AlunosService, times(1)).update(AlunosID, updatedAlunos);
    }

    @Test
    void test_delete() {
        Alunos existingAlunos = AlunossList.get(0);
        Long AlunosID = existingAlunos.getId();

        when(AlunosService.delete(AlunosID)).thenReturn(ResponseEntity.noContent().build());

        ResponseEntity<Void> response = AlunosController.delete(AlunosID);

        assertEquals(ResponseEntity.noContent().build(), response);
        verify(AlunosService, times(1)).delete(AlunosID);
    }

}
