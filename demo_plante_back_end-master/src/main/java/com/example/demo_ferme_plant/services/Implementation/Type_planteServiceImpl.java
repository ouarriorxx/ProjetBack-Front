package com.example.demo_ferme_plant.services.Implementation;

import com.example.demo_ferme_plant.entities.Type_plante;
import com.example.demo_ferme_plant.repository.Type_planteRepository;
import com.example.demo_ferme_plant.services.Type_planteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Type_planteServiceImpl implements Type_planteService {
    @Autowired
    private Type_planteRepository typePlanteRepository;


    @Override
    public Type_plante saveTypePlante(Type_plante typePlante) {
        return  typePlanteRepository.save(typePlante);
    }

    @Override
    public List<Type_plante> getAllTypePlantes() {
        return typePlanteRepository.findAll();
    }

    @Override
    public Type_plante updateTypePlante(Long typePlanteId, Type_plante updatedTypePlante) {
             Type_plante type_planteExist = typePlanteRepository.getById(typePlanteId);
             type_planteExist.setHumidite_max(updatedTypePlante.getHumidite_max());
             type_planteExist.setName(updatedTypePlante.getName());
             type_planteExist.setHumidite_min(updatedTypePlante.getHumidite_min());
             type_planteExist.setTemperature(updatedTypePlante.getTemperature());

               return  typePlanteRepository.save(type_planteExist);
    }

    @Override
    public void deleteTypePlanteById(Long id) {
        typePlanteRepository.deleteById(id);
    }

    @Override
    public Type_plante getTypePlanteById(Long id) {
        return typePlanteRepository.findById(id).orElse(null);
    }
}
