package dev.spacelearning.spacelearning;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class CoursService {
    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Cours> getAllCours() {
        System.out.println("All cours service : " + coursRepository.findAll());
        return coursRepository.findAll();
    }

    public Cours createCours(String nom, LocalDate dateCreation) {
        Cours cours = new Cours();
        cours.setNom(nom);
        cours.setDateCreation(dateCreation);
        cours.setDatesApprentissage(remplirDatesApprentissage(dateCreation)); // Remplir les dates d'apprentissage

        return coursRepository.insert(cours);
    }

    public void deleteCours(ObjectId id) {
        coursRepository.deleteById(id);
    }

    // Méthode pour remplir le tableau de dates d'apprentissage (similaire à celle dans la classe Cours)
    private List<LocalDate> remplirDatesApprentissage(LocalDate dateCreation) {
        List<LocalDate> datesApprentissage = new ArrayList<>();
        LocalDate dateActuelle = dateCreation;
        for (int i = 0; i < 60; i++) {  // 2 mois, soit 60 jours
            datesApprentissage.add(dateActuelle);
            dateActuelle = dateActuelle.plusDays((long) Math.pow(2, i));
        }
        return datesApprentissage;
    }
}