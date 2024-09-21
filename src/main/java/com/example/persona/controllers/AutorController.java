package com.example.persona.controllers;

import com.example.persona.entities.Autor;

import com.example.persona.services.AutorServiceImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{

}
