package dev.spacelearning.spacelearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
