package dev.spacelearning.spacelearning.quotes;

import java.util.Objects;

public class Quotes {
    private Long id;

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    private String text;

    public Quotes(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        // Vérifier si les adresses vont vers le same objet en mémoire
        if (this == o) return true;

        // vérifier si objet à comparer vide ou si il appartient à une classe différente
        if (o == null || getClass() != o.getClass()) return false;

        // cast l'objet en tant que quote vu qu'on sait que c'est bien dans la même classe
        Quotes quote = (Quotes) o;

        // Compare les champs de l'objet courant et de l'objet à comparer
        // Utilise Objects.equals pour gérer les éventuelles valeurs null des champs (id et text)
        return Objects.equals(id, quote.id) && Objects.equals(text, quote.text);
    }
    @Override
    public String toString() {
        return text;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}