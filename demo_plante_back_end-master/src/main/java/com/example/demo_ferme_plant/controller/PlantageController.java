package com.example.demo_ferme_plant.controller;

import com.example.demo_ferme_plant.entities.Plantage;
import com.example.demo_ferme_plant.services.PlantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/plantages")
public class PlantageController {
    @Autowired
    private PlantageService plantageService;

    @PostMapping
    public ResponseEntity<Plantage> createPlantage(@RequestBody Plantage plantage) {
        Plantage savedPlantage = plantageService.savePlantage(plantage);
        return ResponseEntity.ok(savedPlantage);
    }

    @GetMapping
    public ResponseEntity<List<Plantage>> getAllPlantages() {
        List<Plantage> plantages = plantageService.getAllPlantages();
        return ResponseEntity.ok(plantages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plantage> getPlantageById(@PathVariable Long id) {
        Plantage plantage = plantageService.getPlantageById(id);
        return ResponseEntity.ok(plantage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plantage> updatePlantage(@PathVariable Long id, @RequestBody Plantage updatedPlantage) {
        Plantage updated = plantageService.updatePlantage(id, updatedPlantage);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlantage(@PathVariable Long id) {
        plantageService.deletePlantageById(id);
        return ResponseEntity.noContent().build();
    }
}
