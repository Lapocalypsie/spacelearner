package dev.spacelearning.spacelearning;

import java.util.ArrayList;
import java.util.List;

public class Eleve {

    // Attributes
    private String nom;
    private String prenom;
    private String pseudo;
    private int age;
    private String ecole;
    private String email;
    private String motDePasse;
    private List<Cours> coursList;
    private ToDoList toDoList;
    private MesRevisions mesRevisions;

    private List<Cours> coursSuivis;

    // Constructor
    public Eleve(String email, String motDePasse) {
        this.coursList = new ArrayList<>();
        this.toDoList = new ToDoList();
        this.mesRevisions = new MesRevisions();
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public void SuppCoursSuivi(Cours cours) {
        coursList.remove(cours);
    }

    public void AjoutToDoTask(String task) {
        toDoList.ajouterTask(task);
    }

    public void SuppToDoTask(String task) {
        toDoList.supprimerTask(task);
    }

    public void Actualiser() {
        // Your implementation for updating the state of the Eleve object
    }

    // Associations
    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public void setMesRevisions(MesRevisions mesRevisions) {
        this.mesRevisions = mesRevisions;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    public List<Cours> getCoursList() {
        return coursList;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    // Add getter methods for 'nom' and 'age'
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
        return coursSuivis;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
}
