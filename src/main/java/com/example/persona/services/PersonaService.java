package com.example.persona.services;

import com.example.persona.entities.Persona;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{
    List<Persona> search(String filtro) throws Exception;
    List<Persona> searchNativo(String filtro) throws Exception;
    boolean existsByDni(int dni) throws Exception;

}
