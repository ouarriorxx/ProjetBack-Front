package com.example.demo_ferme_plant.services;

import com.example.demo_ferme_plant.entities.Ferme;

import java.util.List;

public interface FermeService {
    Ferme saveFerme(Ferme ferme);

    List<Ferme> getAllFermes();

    Ferme updateFerme(Long fermeId, Ferme updatedFerme);

    void deleteFermeById(Long id);

    Ferme getFermeById(Long id);
}
