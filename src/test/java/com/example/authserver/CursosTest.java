package com.example.authserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.authserver.controller.CursosController;
import com.example.authserver.model.Cursos;
import com.example.authserver.service.CursosService;

@SpringBootTest
public class CursosTest {

    @InjectMocks
    private CursosController CursosController;

    @Mock
    private CursosService CursosService;

    List<Cursos> CursossList = new ArrayList<>();

    @Test
    @BeforeEach
    void test_insert() {
        Cursos newCursos = new Cursos(
                null,
                "Cursos1",
                "Descirção do Curso 1",
                10);
        when(CursosService.save(newCursos)).thenReturn(newCursos);

        Cursos result = CursosController.create(newCursos);

        assertEquals(newCursos, result);

        CursossList.add(newCursos);
    }

    @Test
    void test_getAll() {
        when(CursosService.findAll()).thenReturn(CursossList);

        List<Cursos> response = CursosController.getAll();

        assertEquals(1, response.size());
        verify(CursosService, times(1)).findAll();
    }

    @Test
    void test_update() {

        Cursos existingCursos = CursossList.get(0);
        Long CursosID = existingCursos.getId();

        Cursos updatedCursos = new Cursos(
                null,
                "Cursos1",
                "Descirção do Curso 1",
                10);

        when(CursosService.findById(CursosID)).thenReturn(Optional.of(existingCursos));
        when(CursosService.update(CursosID, updatedCursos)).thenReturn(Optional.of(updatedCursos));

        ResponseEntity<Cursos> response = CursosController.updateCurso(CursosID, updatedCursos);

        assertEquals(ResponseEntity.ok(updatedCursos), response);
        verify(CursosService, times(1)).update(CursosID, updatedCursos);
    }

    @Test
    void test_delete() {
        Cursos existingCursos = CursossList.get(0);
        Long CursosID = existingCursos.getId();

        when(CursosService.delete(CursosID)).thenReturn(ResponseEntity.noContent().build());

        ResponseEntity<Void> response = CursosController.delete(CursosID);

        assertEquals(ResponseEntity.noContent().build(), response);
        verify(CursosService, times(1)).delete(CursosID);
    }

}
