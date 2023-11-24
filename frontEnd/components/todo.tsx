//@ts-nocheck
"use client";
import { useState, useEffect } from "react";
import { Dialogue } from "./shared/dialog";
import axios from "axios";

function ToDo() {
  const [checkedTodos, setCheckedTodos] = useState([]);
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    // Fetch the list of tasks when the component mounts
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/v1/tasks");

      if (response.ok) {
        const data = await response.json();
        console.log("data", data);
        // Update the todos state with the fetched tasks
        setTodos(data);
      } else {
        console.error(
          "Error fetching tasks:",
          response.status,
          response.statusText
        );
      }
    } catch (error) {
      console.error("Error making API call:", error.message);
    }
  };

  const handleTodoCheckboxChange = (todo) => {
    if (checkedTodos.includes(todo)) {
      setCheckedTodos(checkedTodos.filter((t) => t !== todo));
    } else {
      setCheckedTodos([...checkedTodos, todo]);
    }
  };

  const handleDeleteTask = async (task) => {
    const taskId = task.id; // Assuming task.id is an object with properties timestamp and date
    console.log("taskId", taskId);

    if (taskId && taskId.timestamp && taskId.date) {
      try {
        const response = await axios.delete(
          `http://localhost:8080/api/v1/tasks/${taskId.timestamp}`
        );
        if (response.status === 204) {
          // Task deleted successfully, fetch tasks again
          fetchTasks();
        } else {
          console.error(
            "Error deleting task:",
            response.status,
            response.statusText
          );
        }
      } catch (error) {
        console.error("Error making API call:", error.message);
      }
    } else {
      console.error("Task ID is missing or invalid");
    }
  };

  return (
    <div className="container mx-auto p-4">
      <div className="border-4 border-sky-800 rounded container mx-auto p-4">
        <div className="mb-4">
          <h1 className="text-2xl font-bold">🎯 TO DO DU JOUR</h1>
          <hr className="my-4 border-t-2 border-gray-300" />
        </div>
        <ul>
          {todos.map((todo) => (
            <li key={todo.id} className="mb-4">
              <div className="flex items-center justify-between">
                <label
                  className="flex items-center"
                  style={{
                    textDecoration: checkedTodos.includes(todo)
                      ? "line-through"
                      : "none",
                  }}
                >
                  <input
                    type="checkbox"
                    checked={checkedTodos.includes(todo)}
                    onChange={() => handleTodoCheckboxChange(todo)}
                    className="form-checkbox h-4 w-4 text-indigo-600"
                  />
                  <span className="ml-2">{todo.titleList}</span>
                </label>
                <span
                  className="cursor-pointer text-red-500"
                  onClick={() => handleDeleteTask(todo.id)}
                >
                  🗑️
                </span>
              </div>
            </li>
          ))}
        </ul>
        <div className="mt-6 flex items-center justify-center">
          <Dialogue
            buttonTitle="Ajouter une tâche"
            title="Ajouter une tâche"
            description="Ajouter une tâche"
            label1="Titre"
            label2="Description"
            // Fetch tasks again after a new task is added
            onTaskAdded={fetchTasks}
          />
        </div>
      </div>
      <div className="mt-2 flex flex-col container mx-auto p-4">
        <span className="text-lg">
          💪 Bravo ! : {checkedTodos.length} tâches de réalisées !
        </span>
        <span className="text-lg">👊 Plus que {todos.length} maintenant !</span>
      </div>
    </div>
  );
}

export default ToDo;
