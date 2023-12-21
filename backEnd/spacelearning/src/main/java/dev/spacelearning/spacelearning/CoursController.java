package dev.spacelearning.spacelearning;

import dev.spacelearning.spacelearning.Cours;
import dev.spacelearning.spacelearning.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @GetMapping
    public ResponseEntity<List<Cours>> getAllCours() {
        List<Cours> coursList = coursService.getAllCours();
        return new ResponseEntity<>(coursList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cours> createCours(@RequestBody Cours cours) {
        Cours createdCours = coursService.createCours(cours.getNom(), cours.getDateCreation());
        return new ResponseEntity<>(createdCours, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCours(@PathVariable("id") String id) {
        System.out.println("L'ID est : " + id);
        coursService.deleteCours(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
