package dev.spacelearning.spacelearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {
    @Autowired
    private ToDoListRepository toDoListRepository;
    public List<ToDoList> allTasks(){
        System.out.println("All tasks service : "+ toDoListRepository.findAll());
        return toDoListRepository.findAll();
    }
}
