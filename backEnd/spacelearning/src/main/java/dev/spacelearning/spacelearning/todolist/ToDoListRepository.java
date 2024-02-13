package dev.spacelearning.spacelearning.todolist;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends MongoRepository<ToDoList, ObjectId> {
    void deleteBy_id(String id);
}
