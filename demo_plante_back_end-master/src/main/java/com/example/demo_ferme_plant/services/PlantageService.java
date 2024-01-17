package com.example.demo_ferme_plant.services;

import com.example.demo_ferme_plant.entities.Plantage;

import java.util.List;

public interface PlantageService {
    Plantage savePlantage(Plantage plantage);

    List<Plantage> getAllPlantages();

    Plantage updatePlantage(Long plantageId, Plantage updatedPlantage);

    void deletePlantageById(Long id);

    Plantage getPlantageById(Long id);
}
