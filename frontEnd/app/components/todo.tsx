//@ts-nocheck
"use client";
import React, { useState } from "react";

const todos = [
  "Finish homework",
  "Do laundry",
  "Buy groceries",
  "Clean room",
  "Exercise",
];

function ToDo() {
  const [checkedTodos, setCheckedTodos] = useState([]);

  function handleTodoCheckboxChange(todo) {
    if (checkedTodos.includes(todo)) {
      setCheckedTodos(checkedTodos.filter((t) => t !== todo));
    } else {
      setCheckedTodos([...checkedTodos, todo]);
    }
  }

  return (
    <div className="container mx-auto p-4">
      <div className="mb-4">
        <h1 className="text-2xl font-bold">TO DO DU JOUR</h1>
        <hr className="my-4 border-t-2 border-gray-300" />{" "}
        {/* Horizontal line added here */}
      </div>
      <ul>
        {todos.map((todo) => (
          <li key={todo} className="mb-4">
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
              <span className="ml-2">{todo}</span>
            </label>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ToDo;
