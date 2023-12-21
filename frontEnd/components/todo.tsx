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
    const taskId = task._id; // Accessing the _id field
    if (taskId) {
      try {
        const response = await axios.delete(
          `http://localhost:8080/api/v1/tasks/${taskId}`
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
    <div className="">
      <div className="rounded p-8 bg-white">
        <div className="flex items-center mb-6">
          <svg
            className="h-8 w-8 text-indigo-500 stroke-current"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth="2"
              d="M20 13V6a2 2 0 00-2-2H6a2 2 0 00-2 2v7m16 0v5a2 2 0 01-2 2H6a2 2 0 01-2-2v-5m16 0h-2.586a1 1 0 00-.707.293l-2.414 2.414a1 1 0 01-.707.293h-3.172a1 1 0 01-.707-.293l-2.414-2.414A1 1 0 006.586 13H4"
            />
          </svg>
          <h4 className="font-semibold ml-3 text-xl">Tâches du jour</h4>
        </div>
        <ul>
          {todos.map((todo) => (
            <li key={todo.id} className="">
              <div className="flex items-center justify-between rounded-lg p-2 hover:bg-gray-200">
                <label
                  className="flex items-center cursor-pointer"
                  style={{
                    textDecoration: checkedTodos.includes(todo)
                      ? "line-through"
                      : "none",
                  }}
                >
                  <div className="relative">
                    <input
                      type="checkbox"
                      checked={checkedTodos.includes(todo)}
                      onChange={() => handleTodoCheckboxChange(todo)}
                      className="hidden"
                    />
                    <div
                      className={`w-6 h-6 rounded-full border-2 ${
                        checkedTodos.includes(todo)
                          ? "bg-green-500 border-green-500"
                          : "border-gray-300"
                      } flex items-center justify-center`}
                    >
                      {checkedTodos.includes(todo) && (
                        <svg
                          className="w-4 h-4 text-white fill-current"
                          xmlns="http://www.w3.org/2000/svg"
                          viewBox="0 0 20 20"
                        >
                          <path d="M0 11l2-2 5 5L18 3l2 2L7 18z" />
                        </svg>
                      )}
                    </div>
                  </div>
                  <span className="ml-3">{todo.titleList}</span>
                </label>
                <button
                  className="bg-red-500 text-white py-2 px-4 rounded cursor-pointer hover:bg-red-600"
                  onClick={() => handleDeleteTask(todo)}
                >
                  Supprimer
                </button>
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
      {/*<div className="mt-2 flex flex-col container mx-auto p-4">
        <span className="text-lg">
          💪 Bravo ! : {checkedTodos.length} tâches de réalisées !
        </span>
        <span className="text-lg">👊 Plus que {todos.length} maintenant !</span>
      </div>*/}
    </div>
  );
}

export default ToDo;
