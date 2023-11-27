package dev.spacelearning.spacelearning;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class ToDoListController {
    @Autowired
    private ToDoListService toDoListService;
    @GetMapping
    public ResponseEntity<List<ToDoList>> getAllTasks(){
        return new ResponseEntity<List<ToDoList>>(toDoListService.allTasks(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ToDoList> createToDoList(@RequestBody ToDoList toDoList) {
        ToDoList createdToDo = toDoListService.createTodoList(toDoList.getTitleList(), toDoList.getContent(), toDoList.getDone());
        return new ResponseEntity<ToDoList>(createdToDo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoList(@PathVariable("id") ObjectId id) {
        toDoListService.deleteTodoList(id);
    }
}
