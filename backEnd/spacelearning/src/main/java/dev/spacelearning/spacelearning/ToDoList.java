package dev.spacelearning.spacelearning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ToDoList")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoList {
    @Id
    private ObjectId id;
    private String titleList;
    private String content;
    private Boolean isDone;
    private String personalId;

    public Boolean getDone() {
        return isDone;
    }

    public String getContent() {
        return content;
    }

    public String getTitleList() {
        return titleList;
    }

    public ObjectId getId() {
        return id;
    }
}
