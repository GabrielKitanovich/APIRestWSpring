package com.example.persona.controllers;


import com.example.persona.entities.Persona;
import com.example.persona.services.PersonaServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{
    @GetMapping("/search/{filtro}")
    public ResponseEntity<?> search(@PathVariable String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Not found.\"}");
        }
    }

    @GetMapping("/searchNativo/{filtro}")
    public ResponseEntity<?> searchNativo(@PathVariable String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNativo(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Not found.\"}");
        }
    }


    @GetMapping("/existsByDni/{dni}")
    public ResponseEntity<?> existsByDni(@PathVariable int dni){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.existsByDni(dni));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Not found.\"}");
        }
    }
    @GetMapping("/searchPaged/{filtro}")
    public ResponseEntity<?> search(@PathVariable String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Not found.\"}");
        }
    }

    @GetMapping("/searchNativoPaged")
    public ResponseEntity<?> searchNativo(@PathVariable String filtro, @RequestParam Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNativo(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Not found.\"}");
        }
    }


    @GetMapping("/existsByDniPaged")
    public ResponseEntity<?> existsByDni(@PathVariable int dni,@RequestParam Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.existsByDni(dni, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Not found.\"}");
        }
    }
}
