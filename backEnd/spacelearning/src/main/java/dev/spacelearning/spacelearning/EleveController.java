package dev.spacelearning.spacelearning;

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
        Eleve createdEleve = eleveService.createEleve(eleve.getNom(), eleve.getPrenom(), eleve.getPseudo(), eleve.getAge(), eleve.getEcole());
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
}
