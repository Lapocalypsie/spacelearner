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

        for (int i = 0; i < 60; i++) {  // 2 months, 60 days
            datesApprentissage.add(dateActuelle);

            if (i % 7 == 0) {
                // If it's a multiple of 7 (week), increment by 2 days
                dateActuelle = dateActuelle.plusDays(2);
            } else if (i % 7 == 2 || i % 7 == 5) {
                // If it's 2 days after a multiple of 7 or 5 days after a multiple of 7, increment by 1 week
                dateActuelle = dateActuelle.plusWeeks(1);
            } else {
                // Otherwise, increment by 3 weeks
                dateActuelle = dateActuelle.plusWeeks(3);
            }
        }

        return datesApprentissage;
    }



}