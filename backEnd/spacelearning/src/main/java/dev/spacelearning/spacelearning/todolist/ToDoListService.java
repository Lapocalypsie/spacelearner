package dev.spacelearning.spacelearning.todolist;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> allTasks() {
        System.out.println("All tasks service: " + toDoListRepository.findAll());
        return toDoListRepository.findAll();
    }

    public ToDoList createTodoList(String titleList, String content, Boolean isDone) {
        ToDoList toDoList = new ToDoList();
        toDoList.set_id(generateRandomId()); // Set a random string ID
        toDoList.setTitleList(titleList);
        toDoList.setContent(content);
        toDoList.setIsDone(isDone);

        return toDoListRepository.insert(toDoList);
    }

    public void deleteTodoList(String id) {
        toDoListRepository.deleteBy_id(id);
    }

    private String generateRandomId() {
        // Generate a random string ID using UUID
        return UUID.randomUUID().toString().replace("-", "");
    }
}
