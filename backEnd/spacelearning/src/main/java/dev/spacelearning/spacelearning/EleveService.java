package dev.spacelearning.spacelearning;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EleveService {

    @Autowired
    private EleveRepository eleveRepository;

    public List<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    public Eleve createEleve(String nom, String prenom, String pseudo, int age, String ecole) {
        Eleve eleve = new Eleve(nom, prenom, pseudo, age, ecole);
        return eleveRepository.save(eleve);
    }

    public Eleve getEleveById(ObjectId id) {
        return eleveRepository.findById(id).orElse(null);
    }

    public boolean deleteEleve(ObjectId id) {
        if (eleveRepository.existsById(id)) {
            eleveRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
