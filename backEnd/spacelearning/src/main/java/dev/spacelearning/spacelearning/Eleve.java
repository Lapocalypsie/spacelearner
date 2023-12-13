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
    private int nbrCoursSuivis;
    private List<Cours> coursList;
    private ToDoList toDoList;
    private MesRevisions mesRevisions;

    private List<Cours> coursSuivis;

    // Constructor
    public Eleve(String nom, String prenom, String pseudo, int age, String ecole) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.age = age;
        this.ecole = ecole;
        this.nbrCoursSuivis = 0;
        this.coursList = new ArrayList<>();
        this.toDoList = new ToDoList();
        this.mesRevisions = new MesRevisions();
        this.coursSuivis = new ArrayList<>();
    }

    // Methods
    public void AjoutCoursSuivi(Cours cours) {
        coursList.add(cours);
        nbrCoursSuivis++;
    }

    public void SuppCoursSuivi(Cours cours) {
        coursList.remove(cours);
        nbrCoursSuivis--;
    }

    public void AjoutToDoTask(String task) {
        toDoList.ajouterTask(task);
    }

    public void SuppToDoTask(String task) {
        toDoList.supprimerTask(task);
    }

    public void Actualiser() {
        // Your implementation for updating the state of the Etudiant object
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
        this.nbrCoursSuivis = coursList.size();
    }

    public void ajouterCoursSuivi(Cours cours) {
        coursSuivis.add(cours);
        nbrCoursSuivis++;
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
}