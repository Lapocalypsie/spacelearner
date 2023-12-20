package dev.spacelearning.spacelearning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Eleves")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eleve {
    @Id
    private ObjectId id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private String pseudo;
    private int age;
    private String ecole;
    private int nbrCoursSuivis;
    private List<Cours> coursList;
    private List<ToDoList> toDoList;

    // Constructor with email and password
    public Eleve(String email, String password) {
        this.email = email;
        this.password = password;
        this.nbrCoursSuivis = 0;
        this.coursList = new ArrayList<>();
        this.toDoList = new ArrayList<>();
    }

    // Methods
    public void ajouterToDoTask(ToDoList toDo) {
        toDoList.add(toDo);
    }
    public void supprimerToDoTask(String titleList) {
        toDoList.removeIf(toDo -> toDo.getTitleList().equals(titleList));
    }
    // Associations
    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
        this.nbrCoursSuivis = coursList.size();
    }

    public void addCours(Cours cours) {
        if (coursList == null) {
            coursList = new ArrayList<>();
        }
        coursList.add(cours);
        nbrCoursSuivis = coursList.size();
    }
    public List<Cours> getCoursList() {
        return coursList;
    }

    public List<ToDoList> getToDoList() {
        return toDoList;
    }

    // Getter methods for 'email', 'password', 'nom', 'age', 'pseudo', 'prenom', and 'ecole'
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEcole() {
        return ecole;
    }

    public List<Cours> getCoursSuivis() {
        return coursList;
    }
}
