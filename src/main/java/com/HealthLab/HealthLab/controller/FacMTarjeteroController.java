package com.HealthLab.HealthLab.controller;

import com.HealthLab.HealthLab.entity.FacMTarjetero;
import com.HealthLab.HealthLab.services.FacMTarjeteroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarjeteros") // Ruta base para el controlador
@CrossOrigin(origins = "http://localhost")
public class FacMTarjeteroController {

    @Autowired
    private FacMTarjeteroServices facMTarjeteroServices;

    // Obtener todos los tarjeteros
    @GetMapping
    public ResponseEntity<List<FacMTarjetero>> getAllTarjeteros() {
        List<FacMTarjetero> tarjeteros = facMTarjeteroServices.findAll();
        return new ResponseEntity<>(tarjeteros, HttpStatus.OK);
    }

    // Obtener un tarjetero por ID
    @GetMapping("/{id}")
    public ResponseEntity<FacMTarjetero> getTarjeteroById(@PathVariable Long id) {
        FacMTarjetero tarjetero = facMTarjeteroServices.findById(id);
        if (tarjetero != null) {
            return new ResponseEntity<>(tarjetero, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Crear un nuevo tarjetero
    @PostMapping
    public ResponseEntity<FacMTarjetero> createTarjetero(@RequestBody FacMTarjetero facMTarjetero) {
        FacMTarjetero createdTarjetero = facMTarjeteroServices.save(facMTarjetero);
        return new ResponseEntity<>(createdTarjetero, HttpStatus.CREATED);
    }

    // Actualizar un tarjetero existente
    @PutMapping("/{id}")
    public ResponseEntity<FacMTarjetero> updateTarjetero(@PathVariable Long id, @RequestBody FacMTarjetero facMTarjetero) {
        FacMTarjetero updatedTarjetero = facMTarjeteroServices.update(id, facMTarjetero);
        if (updatedTarjetero != null) {
            return new ResponseEntity<>(updatedTarjetero, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar un tarjetero
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarjetero(@PathVariable Long id) {
        boolean isRemoved = facMTarjeteroServices.delete(id);
        if (isRemoved) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
