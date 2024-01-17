package com.example.demo_ferme_plant.controller;

import com.example.demo_ferme_plant.entities.Parcelle;
import com.example.demo_ferme_plant.services.ParcelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/parcelles")
public class ParcelleController {
    @Autowired
    private ParcelleService parcelleService;

    @PostMapping
    public ResponseEntity<Parcelle> createParcelle(@RequestBody Parcelle parcelle) {
        Parcelle savedParcelle = parcelleService.saveParcelle(parcelle);
        return ResponseEntity.ok(savedParcelle);
    }

    @GetMapping
    public ResponseEntity<List<Parcelle>> getAllParcelles() {
        List<Parcelle> parcelles = parcelleService.getAllParcelles();
        return ResponseEntity.ok(parcelles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parcelle> getParcelleById(@PathVariable Long id) {
        Parcelle parcelle = parcelleService.getParcelleById(id);
        return ResponseEntity.ok(parcelle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parcelle> updateParcelle(@PathVariable Long id, @RequestBody Parcelle updatedParcelle) {
        Parcelle updated = parcelleService.updateParcelle(id, updatedParcelle);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParcelle(@PathVariable Long id) {
        parcelleService.deleteParcelleById(id);
        return ResponseEntity.noContent().build();
    }
}
