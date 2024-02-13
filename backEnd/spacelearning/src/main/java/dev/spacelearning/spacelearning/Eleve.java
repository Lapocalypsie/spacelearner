package dev.spacelearning.spacelearning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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
    // Getter methods for 'email', 'password', 'nom', 'age', 'pseudo', 'prenom', and 'ecole'
    @Getter
    private String email;
    @Getter
    private String password;
    @Getter
    private String nom;
    @Getter
    private String prenom;
    @Getter
    private String pseudo;
    @Getter
    private int age;
    @Getter
    private String ecole;
    private int nbrCoursSuivis;
    @Getter
    private List<Cours> coursList;
    @Getter
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

    public List<Cours> getCoursSuivis() {
        return coursList;
    }
}
