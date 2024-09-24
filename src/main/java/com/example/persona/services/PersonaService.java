package com.example.persona.services;

import com.example.persona.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{
    List<Persona> search(String filtro) throws Exception;
    List<Persona> searchNativo(String filtro) throws Exception;
    boolean existsByDni(int dni) throws Exception;
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;
    Page<Persona> searchNativo(String filtro, Pageable pageable) throws Exception;
    Page<Persona> existsByDni(int dni, Pageable pageable) throws Exception;

}
