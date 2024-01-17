package com.example.demo_ferme_plant.services.Implementation;

import com.example.demo_ferme_plant.entities.Plante;
import com.example.demo_ferme_plant.repository.PlanteRepository;
import com.example.demo_ferme_plant.services.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanteServiceImpl implements PlanteService {
    @Autowired
    private PlanteRepository planteRepository;

    @Override
    public Plante savePlante(Plante plante) {
        return planteRepository.save(plante);
    }

    @Override
    public List<Plante> getAllPlantes() {
        return planteRepository.findAll();
    }

    @Override
    public Plante updatePlante(Long planteId, Plante updatedPlante) {
        if (planteRepository.existsById(planteId)) {
            updatedPlante.setId(planteId);
            return planteRepository.save(updatedPlante);
        }
        return null; // Gérer le cas où la Plante avec l'ID spécifié n'existe pas
    }

    @Override
    public void deletePlanteById(Long id) {
        planteRepository.deleteById(id);
    }

    @Override
    public Plante getPlanteById(Long id) {
        return planteRepository.findById(id).orElse(null);
    }
}
