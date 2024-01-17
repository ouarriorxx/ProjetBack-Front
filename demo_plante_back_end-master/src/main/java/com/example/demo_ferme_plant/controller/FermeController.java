package com.example.demo_ferme_plant.controller;

import com.example.demo_ferme_plant.entities.Ferme;
import com.example.demo_ferme_plant.services.FermeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/fermes")
public class FermeController {
    @Autowired
    private FermeService fermeService;

    @PostMapping
    public ResponseEntity<Ferme> createFerme(@RequestBody Ferme ferme) {
        Ferme savedFerme = fermeService.saveFerme(ferme);
        return ResponseEntity.ok(savedFerme);
    }

    @GetMapping
    public ResponseEntity<List<Ferme>> getAllFermes() {
        List<Ferme> fermes = fermeService.getAllFermes();
        return ResponseEntity.ok(fermes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ferme> getFermeById(@PathVariable Long id) {
        Ferme ferme = fermeService.getFermeById(id);
        return ResponseEntity.ok(ferme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ferme> updateFerme(@PathVariable Long id, @RequestBody Ferme updatedFerme) {
        Ferme updated = fermeService.updateFerme(id, updatedFerme);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFerme(@PathVariable Long id) {
        fermeService.deleteFermeById(id);
        return ResponseEntity.noContent().build();
    }
}
