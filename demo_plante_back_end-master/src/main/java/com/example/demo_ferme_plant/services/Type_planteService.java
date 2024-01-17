package com.example.demo_ferme_plant.services;

import com.example.demo_ferme_plant.entities.Type_plante;

import java.util.List;

public interface Type_planteService {
    Type_plante saveTypePlante(Type_plante typePlante);

    List<Type_plante> getAllTypePlantes();

    Type_plante updateTypePlante(Long typePlanteId, Type_plante updatedTypePlante);

    void deleteTypePlanteById(Long id);

    Type_plante getTypePlanteById(Long id);
}
