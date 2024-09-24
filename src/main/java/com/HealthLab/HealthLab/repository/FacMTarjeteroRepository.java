package com.HealthLab.HealthLab.repository;

import com.HealthLab.HealthLab.entity.FacMTarjetero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacMTarjeteroRepository extends JpaRepository<FacMTarjetero, Long> {
    @Query("select f from FacMTarjetero f order by f.id desc") // Cambia 'f.id' por el campo por el que quieras ordenar
    List<FacMTarjetero> findAllOrderedById();
}
