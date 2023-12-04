package dev.spacelearning.spacelearning;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveRepository extends MongoRepository<Eleve, ObjectId> {
    List<Eleve> findAll();

    boolean existsById(ObjectId id);

    void deleteById(ObjectId id);

    Eleve save(Eleve eleve);
    // You can add custom query methods if needed
}
