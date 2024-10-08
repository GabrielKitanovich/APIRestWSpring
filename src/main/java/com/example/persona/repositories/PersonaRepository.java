package com.example.persona.repositories;


import com.example.persona.entities.Persona;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido) throws Exception;

    //boolean existsByDni(int dni) throws Exception;
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    List<Persona> search(String filtro) throws Exception;

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %?1% OR persona.apellido LIKE %?1%",
            nativeQuery = true
    )
    List<Persona> searchNativo(String filtro) throws Exception;

    @Query(value = "SELECT * FROM persona WHERE persona.dni = ?1", nativeQuery = true)
    boolean existsByDni(int dni) throws Exception;

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %?1% OR persona.apellido LIKE %?1%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(String filtro, Pageable pageable) throws Exception;

    @Query(
            value = "SELECT * FROM persona WHERE persona.dni = ?1",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true)
    Page<Persona> existsByDni(int dni, Pageable pageable) throws Exception;


}
