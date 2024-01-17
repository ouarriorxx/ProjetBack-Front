package com.example.demo_ferme_plant.controller;

import com.example.demo_ferme_plant.entities.Plante;
import com.example.demo_ferme_plant.services.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/plantes")
public class PlanteController {
    @Autowired
    private PlanteService planteService;

    @PostMapping
    public ResponseEntity<Plante> createPlante(@RequestBody Plante plante) {
        Plante savedPlante = planteService.savePlante(plante);
        return ResponseEntity.ok(savedPlante);
    }

    @GetMapping
    public ResponseEntity<List<Plante>> getAllPlantes() {
        List<Plante> plantes = planteService.getAllPlantes();
        return ResponseEntity.ok(plantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plante> getPlanteById(@PathVariable Long id) {
        Plante plante = planteService.getPlanteById(id);
        return ResponseEntity.ok(plante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plante> updatePlante(@PathVariable Long id, @RequestBody Plante updatedPlante) {
        Plante updated = planteService.updatePlante(id, updatedPlante);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlante(@PathVariable Long id) {
        planteService.deletePlanteById(id);
        return ResponseEntity.noContent().build();
    }
}
