package com.HealthLab.HealthLab.repository;

import com.HealthLab.HealthLab.entity.FacMTarjetero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacMTarjeteroRepository extends JpaRepository<FacMTarjetero, Long> {
}
