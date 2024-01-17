package com.example.demo_ferme_plant.repository;

import com.example.demo_ferme_plant.entities.Parcelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelleRepository extends JpaRepository<Parcelle,Long> {
}
