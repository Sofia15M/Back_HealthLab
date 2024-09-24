package com.HealthLab.HealthLab.services;

import com.HealthLab.HealthLab.entity.FacPCups;
import com.HealthLab.HealthLab.repository.FacPCupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacPCupsService {

    @Autowired
    private FacPCupsRepository repository;

    public List<FacPCups> findAll() {
        return repository.findAll();
    }

    public FacPCups findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public FacPCups save(FacPCups facPCups) {
        return repository.save(facPCups);
    }

    public FacPCups update(Integer id, FacPCups facPCups) {
        if (!repository.existsById(id)) {
            return null; // O lanzar una excepción
        }
        facPCups.setId(id);
        return repository.save(facPCups);
    }

    public boolean delete(Integer id) {
        if (!repository.existsById(id)) {
            return false; // O lanzar una excepción
        }
        repository.deleteById(id);
        return true;
    }
}
