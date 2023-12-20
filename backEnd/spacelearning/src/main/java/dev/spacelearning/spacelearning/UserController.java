package dev.spacelearning.spacelearning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final List<Eleve> eleveList = List.of(
            new Eleve("jean.d@example.com", "password1"),
            new Eleve("marie.m@example.com", "password2"),
            new Eleve("pierre.l@example.com", "password3"),
            new Eleve("warren.l@example.com", "password4"),
            new Eleve("claire.s@example.com", "password5"),
            new Eleve("luc.g@example.com", "password6"),
            new Eleve("sophie.l@example.com", "password7"),
            new Eleve("alexandre.m@example.com", "password8"),
            new Eleve("lionel.m@example.com", "password9"),
            new Eleve("chris.r@example.com", "password10")
    );

    @GetMapping
    public List<UserDTO> getUsers() {
        // Return a list of users with only email and password
        return eleveList.stream()
                .map(user -> new UserDTO(user.getEmail(), user.getMotDePasse()))
                .collect(Collectors.toList());
    }

    // Define a DTO class for User with only email and password
    private static class UserDTO {
        private final String email;
        private final String motDePasse;

        public UserDTO(String email, String motDePasse) {
            this.email = email;
            this.motDePasse = motDePasse;
        }

        public String getEmail() {
            return email;
        }

        public String getMotDePasse() {
            return motDePasse;
        }
    }
}


