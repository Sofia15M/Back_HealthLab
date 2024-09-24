package com.HealthLab.HealthLab.services;

import com.HealthLab.HealthLab.entity.FacMTarjetero;
import com.HealthLab.HealthLab.repository.FacMTarjeteroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacMTarjeteroServices {

    @Autowired
    private FacMTarjeteroRepository facMTarjeteroRepository;

    // Obtener todos los FacMTarjetero
    public List<FacMTarjetero> getAllFacMTarjetero() {
        return facMTarjeteroRepository.findAll();
    }

    // Obtener un FacMTarjetero por ID
    public Optional<FacMTarjetero> getFacMTarjeteroById(Long id) {
        return facMTarjeteroRepository.findById(id);
    }

    // Guardar un nuevo FacMTarjetero
    public FacMTarjetero save(FacMTarjetero facMTarjetero) {
        return facMTarjeteroRepository.save(facMTarjetero);
    }

    // Actualizar un FacMTarjetero existente
    public FacMTarjetero update(Long id, FacMTarjetero facMTarjetero) {
        if (facMTarjeteroRepository.existsById(id)) {
            facMTarjetero.setId(id); // Asegúrate de que el ID se mantenga correcto
            return facMTarjeteroRepository.save(facMTarjetero);
        }
        return null; // O lanza una excepción según lo que desees manejar
    }

    // Eliminar un FacMTarjetero
    public boolean delete(Long id) {
        if (facMTarjeteroRepository.existsById(id)) {
            facMTarjeteroRepository.deleteById(id);
            return true;
        }
        return false; // O lanza una excepción según lo que desees manejar
    }
}
