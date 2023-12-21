package dev.spacelearning.spacelearning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ToDoList")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoList {
    @Id
    private String _id; // Use String for custom ID
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
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    // Getter and setter for id
    public String getId() {
        return _id;
    }

    public void setId() {
        // Generate a random ObjectId and set it as a string
        this._id = new ObjectId().toString();
    }
}
