package dev.spacelearning.spacelearning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cours {
    @Id
    private ObjectId id;
    private String nom;
    private LocalDate dateCreation;
    private List<LocalDate> datesApprentissage;

    // Constructeur
    public Cours(ObjectId id, String nom, LocalDate dateCreation) {
        this.id = id;
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.datesApprentissage = remplirDatesApprentissage();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<LocalDate> getDatesApprentissage() {
        return datesApprentissage;
    }

    public void setDatesApprentissage(List<LocalDate> datesApprentissage) {
        this.datesApprentissage = datesApprentissage;
    }

    private List<LocalDate> remplirDatesApprentissage() {
        List<LocalDate> datesApprentissage = new ArrayList<>();
        LocalDate dateActuelle = dateCreation;
        for (int i = 0; i < 60; i++) {
            datesApprentissage.add(dateActuelle);
            dateActuelle = dateActuelle.plusDays((long) Math.pow(2, i));
        }
        return datesApprentissage;
    }
    }
