package com.example.demo_ferme_plant.services.Implementation;

import com.example.demo_ferme_plant.entities.Parcelle;
import com.example.demo_ferme_plant.repository.ParcelleRepository;
import com.example.demo_ferme_plant.services.ParcelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParcelleServiceImpl implements ParcelleService {

    @Autowired
    private ParcelleRepository parcelleRepository;

    @Override
    public Parcelle saveParcelle(Parcelle parcelle) {
        return parcelleRepository.save(parcelle);
    }

    @Override
    public List<Parcelle> getAllParcelles() {
        return parcelleRepository.findAll();
    }

    @Override
    public Parcelle updateParcelle(Long parcelleId, Parcelle updatedParcelle) {
    Parcelle parcelleExist = parcelleRepository.getById(parcelleId);
    parcelleExist.setImage_parcelle(updatedParcelle.getImage_parcelle());
    parcelleExist.setLibelle(updatedParcelle.getLibelle());
    return  parcelleRepository.save(parcelleExist);

    }

    @Override
    public void deleteParcelleById(Long id) {
        parcelleRepository.deleteById(id);
    }

    @Override
    public Parcelle getParcelleById(Long id) {
        return parcelleRepository.findById(id).orElse(null);
    }
}
