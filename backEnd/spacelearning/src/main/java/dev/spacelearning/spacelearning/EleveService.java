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

    public Eleve createEleve(String email, String password) {
        Eleve eleve = new Eleve(email, password);
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

    // Add task to Eleve's ToDoList
    public void addTaskToEleve(ObjectId id, ToDoList toDo) {
        Eleve eleve = eleveRepository.findById(id).orElse(null);
        if (eleve != null) {
            eleve.ajouterToDoTask(toDo);
            eleveRepository.save(eleve);
        }
    }

    // Remove task from Eleve's ToDoList
    public void removeTaskFromEleve(ObjectId id, String titleList) {
        Eleve eleve = eleveRepository.findById(id).orElse(null);
        if (eleve != null) {
            eleve.supprimerToDoTask(titleList);
            eleveRepository.save(eleve);
        }
    }

    // Update an Eleve
    public void updateEleve(Eleve eleve) {
        eleveRepository.save(eleve);
    }
}
