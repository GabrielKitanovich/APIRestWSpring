package com.example.persona.services;

import com.example.persona.repositories.BaseRepository;
import com.example.persona.entities.Persona;
import com.example.persona.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;


    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            List<Persona> personas = personaRepository.search(filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> searchNativo(String filtro) throws Exception {
        try {
            List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



    @Override
    public boolean existsByDni(int dni) throws Exception {
        try {
            return personaRepository.existsByDni(dni);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
