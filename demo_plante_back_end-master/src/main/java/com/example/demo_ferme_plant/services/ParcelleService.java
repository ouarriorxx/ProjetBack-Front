package com.example.demo_ferme_plant.services;

import com.example.demo_ferme_plant.entities.Parcelle;

import java.util.List;

public interface ParcelleService {

    Parcelle saveParcelle(Parcelle parcelle);

    List<Parcelle> getAllParcelles();

    Parcelle updateParcelle(Long parcelleId, Parcelle updatedParcelle);

    void deleteParcelleById(Long id);

    Parcelle getParcelleById(Long id);
}
