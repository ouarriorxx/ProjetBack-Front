package com.example.demo_ferme_plant.services;

import com.example.demo_ferme_plant.entities.Plante;

import java.util.List;

public interface PlanteService {
    Plante savePlante(Plante plante);

    List<Plante> getAllPlantes();

    Plante updatePlante(Long planteId, Plante updatedPlante);

    void deletePlanteById(Long id);

    Plante getPlanteById(Long id);
}
