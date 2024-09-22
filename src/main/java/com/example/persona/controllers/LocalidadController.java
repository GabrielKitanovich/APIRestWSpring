package com.example.persona.controllers;

import com.example.persona.entities.Autor;

import com.example.persona.entities.Localidad;
import com.example.persona.services.AutorServiceImpl;

import com.example.persona.services.LocalidadServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{

}
