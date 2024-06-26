package com.example.demo.controller;

import com.example.demo.entities.Tutor;
import com.example.demo.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping("/list")
    public List<Tutor> listAllTutores() {
        return tutorService.listAll();
    }

    @GetMapping("/{id}")
    public Tutor obtenerTutorPorId(@PathVariable Integer id) {
        return tutorService.obtenerTutorPorId(id);
    }

    @PostMapping("/crear")
    public Tutor crearTutor(@RequestBody Tutor tutor) {
        return tutorService.guardarTutor(tutor);
    }

    @GetMapping("/codigo/{codigo}")
    public Tutor obtenerTutorPorCodigo(@PathVariable String codigo) {
        return tutorService.obtenerTutorPorCodigo(codigo);
    }

    @DeleteMapping("/delete")
    public Tutor eliminarTutorPorCodigo(@RequestParam String codigo) {
        return tutorService.eliminarTutorPorCodigo(codigo);
    }

    @PutMapping("/actualizar/{id}")
    public Tutor actualizarTutor(@PathVariable int id, @RequestParam String nombre, @RequestParam String correo, @RequestParam String codigo) {
        return tutorService.actualizarTutor(id, nombre, correo, codigo);
    }

    @PutMapping("/actualizarNombreYCorreo/{id}")
    public Tutor actualizarNombreYCorreo(@PathVariable int id, @RequestParam String nombre, @RequestParam String correo) {
        return tutorService.actualizarNombreYCorreo(id, nombre, correo);
    }
}