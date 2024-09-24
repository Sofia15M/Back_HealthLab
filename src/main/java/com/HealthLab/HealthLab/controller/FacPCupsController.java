package com.HealthLab.HealthLab.controller;

import com.HealthLab.HealthLab.entity.FacPCups;
import com.HealthLab.HealthLab.service.FacPCupsService; // Asegúrate de tener el servicio importado
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cups") // Cambia la ruta según lo necesites
@CrossOrigin(origins = "*") // Permitir acceso desde cualquier origen, ajusta según sea necesario
public class FacPCupsController {

    @Autowired
    private FacPCupsService facPCupsService;

    @GetMapping
    public ResponseEntity<List<FacPCups>> getAllCups() {
        List<FacPCups> cups = facPCupsService.findAll();
        return new ResponseEntity<>(cups, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacPCups> getCupById(@PathVariable Integer id) {
        FacPCups cup = facPCupsService.findById(id);
        return cup != null ? new ResponseEntity<>(cup, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<FacPCups> createCup(@RequestBody FacPCups facPCups) {
        FacPCups createdCup = facPCupsService.save(facPCups);
        return new ResponseEntity<>(createdCup, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacPCups> updateCup(@PathVariable Integer id, @RequestBody FacPCups facPCups) {
        FacPCups updatedCup = facPCupsService.update(id, facPCups);
        return updatedCup != null ? new ResponseEntity<>(updatedCup, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCup(@PathVariable Integer id) {
        boolean isDeleted = facPCupsService.delete(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
