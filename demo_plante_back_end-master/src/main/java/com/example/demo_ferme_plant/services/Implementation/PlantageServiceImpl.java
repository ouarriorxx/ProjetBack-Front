package com.example.demo_ferme_plant.services.Implementation;

import com.example.demo_ferme_plant.entities.Plantage;
import com.example.demo_ferme_plant.repository.PlantageRepository;
import com.example.demo_ferme_plant.services.PlantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlantageServiceImpl implements PlantageService {

    @Autowired
    private PlantageRepository plantageRepository;

    @Override
    public Plantage savePlantage(Plantage plantage) {
        return plantageRepository.save(plantage);
    }

    @Override
    public List<Plantage> getAllPlantages() {
        return plantageRepository.findAll();
    }

    @Override
    public Plantage updatePlantage(Long plantageId, Plantage updatedPlantage) {
        if (plantageRepository.existsById(plantageId)) {
            updatedPlantage.setId(plantageId);
            return plantageRepository.save(updatedPlantage);
        }
        return null; // Gérer le cas où le Plantage avec l'ID spécifié n'existe pas
    }

    @Override
    public void deletePlantageById(Long id) {
        plantageRepository.deleteById(id);
    }

    @Override
    public Plantage getPlantageById(Long id) {
        return plantageRepository.findById(id).orElse(null);
    }
}
