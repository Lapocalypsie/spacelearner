package dev.spacelearning.spacelearning.todolist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class ToDoListController {
    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping
    public ResponseEntity<List<ToDoList>> getAllTasks() {
        List<ToDoList> tasks = toDoListService.allTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ToDoList> createToDoList(@RequestBody ToDoList toDoList) {
        ToDoList createdToDo = toDoListService.createTodoList(toDoList.getTitleList(), toDoList.getContent(), toDoList.getDone());
        return new ResponseEntity<>(createdToDo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoList(@PathVariable("id") String id) {
        toDoListService.deleteTodoList(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
