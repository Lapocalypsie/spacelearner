package dev.spacelearning.spacelearning;

public class TestEleve {
    public static void main(String[] args) {
        // Create instances of Eleve manually
        Eleve eleve1 = new Eleve("jean.d@example.com", "password1");
        Eleve eleve2 = new Eleve("marie.m@example.com", "password2");
        Eleve eleve3 = new Eleve("pierre.l@example.com", "password3");
        Eleve eleve4 = new Eleve("warren.l@example.com", "password4");
        Eleve eleve5 = new Eleve("claire.s@example.com", "password5");
        Eleve eleve6 = new Eleve("luc.g@example.com", "password6");
        Eleve eleve7 = new Eleve("sophie.l@example.com", "password7");
        Eleve eleve8 = new Eleve("alexandre.m@example.com", "password8");
        Eleve eleve9 = new Eleve("lionel.m@example.com", "password9");
        Eleve eleve10 = new Eleve("chris.r@example.com", "password10");

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
        System.out.println("Email: " + eleve.getEmail());
        System.out.println("Number of Courses: " + eleve.getCoursList().size());
        System.out.println("Number of ToDo Tasks: " + eleve.getToDoList().getTasks().size());
        System.out.println();
    }
}
