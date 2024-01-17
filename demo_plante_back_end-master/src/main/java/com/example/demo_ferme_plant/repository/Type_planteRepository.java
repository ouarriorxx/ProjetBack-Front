package com.example.demo_ferme_plant.repository;

import com.example.demo_ferme_plant.entities.Type_plante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Type_planteRepository extends JpaRepository<Type_plante,Long> {
}
