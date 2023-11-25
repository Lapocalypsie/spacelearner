package dev.spacelearning.spacelearning;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {
    @Autowired
    private ToDoListRepository toDoListRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public List<ToDoList> allTasks(){
        System.out.println("All tasks service : "+ toDoListRepository.findAll());
        return toDoListRepository.findAll();
    }

    public ToDoList createTodoList(String titleList, String content, Boolean isDone) {
        ToDoList toDoList = new ToDoList();
        toDoList.setTitleList(titleList);
        toDoList.setContent(content);
        toDoList.setIsDone(isDone);

        return toDoListRepository.insert(toDoList);

    }
}
