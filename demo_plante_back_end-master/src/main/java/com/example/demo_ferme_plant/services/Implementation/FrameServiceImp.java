package com.example.demo_ferme_plant.services.Implementation;

import com.example.demo_ferme_plant.entities.Ferme;
import com.example.demo_ferme_plant.repository.FermeRepository;
import com.example.demo_ferme_plant.services.FermeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FrameServiceImp implements FermeService {
    @Autowired
    FermeRepository fermeRepository;
    @Override
    public Ferme saveFerme(Ferme ferme) {
        return fermeRepository.save(ferme);
    }

    @Override
    public List<Ferme> getAllFermes() {
        return fermeRepository.findAll();
    }

    @Override
    public Ferme updateFerme(Long fermeId, Ferme updatedFerme) {
        Ferme fermeExist = fermeRepository.getById(fermeId);
            fermeExist.setImage_ferme(updatedFerme.getImage_ferme());
            fermeExist.setLibelle(updatedFerme.getLibelle());
            return fermeRepository.save(fermeExist);

    }

    @Override
    public void deleteFermeById(Long id) {
        fermeRepository.deleteById(id);
    }

    @Override
    public Ferme getFermeById(Long id) {
        return fermeRepository.findById(id).get();
    }
}
