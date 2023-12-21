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
    private String _id; // Use String for custom ID
    private String nom;
    private LocalDate dateCreation;
    private List<LocalDate> datesApprentissage;

    // Constructor
    public Cours(String nom, LocalDate dateCreation) {
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.datesApprentissage = remplirDatesApprentissage();
    }

    // Getters and Setters
    public void set_id(String _id) {
        this._id = _id;
    }

    // Getter and setter for id
    public String getId() {
        return _id;
    }

    public void setId() {
        // Generate a random ObjectId and set it as a string
        this._id = new ObjectId().toString();
    }
    // Getter and setter for id


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
