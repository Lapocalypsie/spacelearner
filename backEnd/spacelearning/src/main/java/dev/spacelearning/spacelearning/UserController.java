package dev.spacelearning.spacelearning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final List<Eleve> eleveList = List.of(
            new Eleve("Dupont", "Jean", "jeand", 21, "ESIEE Paris"),
            new Eleve("Martin", "Marie", "mariem", 22, "Sorbonne Université"),
            new Eleve("Leblanc", "Pierre", "pierrel", 23, "Université Paris-Sud"),
            new Eleve("Lefevre", "Warren", "warrenl", 24, "Université Paris Diderot"),
            new Eleve("Simon", "Claire", "claires", 24, "Télécom Paris"),
            new Eleve("Girard", "Luc", "lucg", 19, "Université Paris Dauphine"),
            new Eleve("Lefort", "Sophie", "sophiel", 22, "HEC Paris"),
            new Eleve("Mbappe", "Alexandre", "alexm", 22, "Université Paris Descartes"),
            new Eleve("Messi", "Lionel", "leom", 23, "ENS Paris"),
            new Eleve("Ronaldo", "Chris", "chrisr", 23, "Université Paris Nanterre")
    );

    @GetMapping
    public List<Eleve> getUsers() {
        return eleveList;
    }
}


