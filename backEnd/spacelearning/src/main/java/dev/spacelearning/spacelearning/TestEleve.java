package dev.spacelearning.spacelearning;

public class TestEleve {
    public static void main(String[] args) {
        // Create instances of Eleve manually
        Eleve eleve1 = new Eleve("Dupont", "Jean", "jeand", 21, "ESIEE Paris");
        Eleve eleve2 = new Eleve("Martin", "Marie", "mariem", 22, "Sorbonne Université");
        Eleve eleve3 = new Eleve("Leblanc", "Pierre", "pierrel", 23, "Université Paris-Sud");
        Eleve eleve4 = new Eleve("Lefevre", "Warren", "warrenl", 24, "Université Paris Diderot");
        Eleve eleve5 = new Eleve("Simon", "Claire", "claires", 24, "Télécom Paris");
        Eleve eleve6 = new Eleve("Girard", "Luc", "lucg", 19, "Université Paris Dauphine");
        Eleve eleve7 = new Eleve("Lefort", "Sophie", "sophiel", 22, "HEC Paris");
        Eleve eleve8 = new Eleve("Mbappe", "Alexandre", "alexm", 22, "Université Paris Descartes");
        Eleve eleve9 = new Eleve("Messi", "Lionel", "leom", 23, "ENS Paris");
        Eleve eleve10 = new Eleve("Ronaldo", "Chris", "chrisr", 23, "Université Paris Nanterre");

        // Add courses and ToDo tasks as needed

        // Display information about each student
        displayStudentInfo(eleve1);
        displayStudentInfo(eleve2);
        displayStudentInfo(eleve3);
        displayStudentInfo(eleve4);
        displayStudentInfo(eleve5);
        displayStudentInfo(eleve6);
        displayStudentInfo(eleve7);
        displayStudentInfo(eleve8);
        displayStudentInfo(eleve9);
        displayStudentInfo(eleve10);
    }

    private static void displayStudentInfo(Eleve eleve) {
        System.out.println("Student Information:");
        System.out.println("Nom: " + eleve.getNom());
        System.out.println("Prenom: " + eleve.getPrenom());
        System.out.println("Pseudo: " + eleve.getPseudo());
        System.out.println("Age: " + eleve.getAge());
        System.out.println("Ecole: " + eleve.getEcole());
        System.out.println("Number of Courses: " + eleve.getCoursList().size());
        System.out.println("Number of ToDo Tasks: " + eleve.getToDoList().getTasks().size());
        System.out.println();
    }
}
