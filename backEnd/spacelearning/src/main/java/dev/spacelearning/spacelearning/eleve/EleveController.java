package dev.spacelearning.spacelearning.eleve;

import dev.spacelearning.spacelearning.cours.Cours;
import dev.spacelearning.spacelearning.todolist.ToDoList;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eleves")
public class EleveController {

    @Autowired
    private EleveService eleveService;

    @GetMapping
    public ResponseEntity<List<Eleve>> getAllEleves() {
        return new ResponseEntity<>(eleveService.getAllEleves(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Eleve> createEleve(@RequestBody Eleve eleve) {
        Eleve createdEleve = eleveService.createEleve(eleve.getEmail(), eleve.getPassword());
        return new ResponseEntity<>(createdEleve, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eleve> getEleveById(@PathVariable("id") String id) {
        ObjectId objectId = new ObjectId(id);
        Eleve eleve = eleveService.getEleveById(objectId);
        if (eleve != null) {
            return new ResponseEntity<>(eleve, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEleve(@PathVariable("id") String id) {
        ObjectId objectId = new ObjectId(id);
        boolean deleted = eleveService.deleteEleve(objectId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eleve> updateEleve(@PathVariable("id") String id, @RequestBody Eleve updatedEleve) {
        ObjectId objectId = new ObjectId(id);
        Eleve existingEleve = eleveService.getEleveById(objectId);

        if (existingEleve != null) {
            // Update the existingEleve with the fields from updatedEleve
            existingEleve.setAge(updatedEleve.getAge());

            // Add courses from updatedEleve to existingEleve's coursList
            if (updatedEleve.getCoursList() != null) {
                for (Cours updatedCours : updatedEleve.getCoursList()) {
                    existingEleve.addCours(updatedCours);
                }
            }

            // Add ToDoList items from updatedEleve to existingEleve's toDoList
            if (updatedEleve.getToDoList() != null) {
                for (ToDoList updatedToDo : updatedEleve.getToDoList()) {
                    existingEleve.ajouterToDoTask(updatedToDo);
                }
            }

            eleveService.updateEleve(existingEleve);

            return new ResponseEntity<>(existingEleve, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/{id}/tasks")
    public ResponseEntity<Void> addTaskToEleve(@PathVariable("id") String id, @RequestBody ToDoList toDo) {
        ObjectId objectId = new ObjectId(id);
        eleveService.addTaskToEleve(objectId, toDo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/tasks/{titleList}")
    public ResponseEntity<Void> removeTaskFromEleve(@PathVariable("id") String id, @PathVariable("titleList") String titleList) {
        ObjectId objectId = new ObjectId(id);
        eleveService.removeTaskFromEleve(objectId, titleList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
