package com.example.demo_ferme_plant.controller;

import com.example.demo_ferme_plant.entities.Type_plante;
import com.example.demo_ferme_plant.services.Type_planteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/typeplantes")
public class Type_planteController {
    @Autowired
    private Type_planteService typePlanteService;

    @PostMapping
    public ResponseEntity<Type_plante> createTypePlante(@RequestBody Type_plante typePlante) {
        Type_plante savedTypePlante = typePlanteService.saveTypePlante(typePlante);
        return ResponseEntity.ok(savedTypePlante);
    }

    @GetMapping
    public ResponseEntity<List<Type_plante>> getAllTypePlantes() {
        List<Type_plante> typePlantes = typePlanteService.getAllTypePlantes();
        return ResponseEntity.ok(typePlantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type_plante> getTypePlanteById(@PathVariable Long id) {
        Type_plante typePlante = typePlanteService.getTypePlanteById(id);
        return ResponseEntity.ok(typePlante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type_plante> updateTypePlante(@PathVariable Long id, @RequestBody Type_plante updatedTypePlante) {
        Type_plante updated = typePlanteService.updateTypePlante(id, updatedTypePlante);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypePlante(@PathVariable Long id) {
        typePlanteService.deleteTypePlanteById(id);
        return ResponseEntity.noContent().build();
    }
}
