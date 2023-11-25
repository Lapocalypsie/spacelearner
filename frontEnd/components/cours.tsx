import React, { useState } from "react";

interface CourseProps {
  id: number;
  name: string;
  date: string;
  status: boolean;
  nextRevision: string; // New property for the next revision date
  onToggle: (id: number) => void;
  onRemove: (id: number) => void;
}

const Course: React.FC<CourseProps> = ({
  id,
  name,
  date,
  status,
  nextRevision,
  onToggle,
  onRemove,
}) => {
  return (
    <tr className={`course ${status ? "bg-green-100" : "bg-red-100"}`}>
      <td className="p-2">
        <input
          type="checkbox"
          checked={status}
          onChange={() => onToggle(id)}
          className="form-checkbox text-indigo-600 h-5 w-5"
        />
      </td>
      <td className="p-2">{name}</td>
      <td className="p-2">{date}</td>
      <td className="p-2">{nextRevision}</td>{" "}
      {/* New column for next revision */}
      <td className="p-2">
        <button
          onClick={() => onRemove(id)}
          className="bg-red-500 text-white py-1 px-2 rounded"
        >
          Remove
        </button>
      </td>
    </tr>
  );
};

const CourseList: React.FC = () => {
  const [courses, setCourses] = useState([
    {
      id: 1,
      name: "Math",
      date: "2022-01-01",
      status: false,
      nextRevision: "2023-01-01",
    },
    {
      id: 2,
      name: "Science",
      date: "2022-01-02",
      status: true,
      nextRevision: "2023-01-02",
    },
    {
      id: 3,
      name: "History",
      date: "2022-01-03",
      status: false,
      nextRevision: "2023-01-03",
    },
  ]);

  const [newCourse, setNewCourse] = useState({
    name: "",
    date: "",
    status: false,
    nextRevision: "", // Initialize next revision for new courses
  });

  const handleToggle = (id: number) => {
    setCourses(
      courses.map((course) =>
        course.id === id ? { ...course, status: !course.status } : course
      )
    );
  };

  const handleRemove = (id: number) => {
    setCourses(courses.filter((course) => course.id !== id));
  };

  const handleAdd = () => {
    const newId = Math.max(...courses.map((course) => course.id), 0) + 1;
    setCourses([...courses, { ...newCourse, id: newId }]);
    setNewCourse({ name: "", date: "", status: false, nextRevision: "" });
  };

  return (
    <div className="container mx-auto px-4 py-4 border border-purple-400 p-4 rounded-lg">
      <h1 className="font-bold text-2xl mb-4">Mes cours</h1>
      <div className="overflow-x-auto">
        <table className="w-full border-collapse">
          <thead>
            <tr className="bg-gray-100">
              <th className="p-2">Status</th>
              <th className="p-2">Course</th>
              <th className="p-2">{"Date d'ajout"}</th>
              <th className="p-2">Prochaine révision</th>{" "}
              {/* New column header */}
              <th className="p-2">Action</th>
            </tr>
          </thead>
          <tbody>
            {courses.map((course) => (
              <Course
                key={course.id}
                {...course}
                onToggle={handleToggle}
                onRemove={handleRemove}
              />
            ))}
          </tbody>
          <tfoot>
            <tr className="border-t">
              <td className="p-2">
                <input
                  type="checkbox"
                  checked={newCourse.status}
                  onChange={() =>
                    setNewCourse({ ...newCourse, status: !newCourse.status })
                  }
                  className="form-checkbox text-indigo-600 h-5 w-5"
                />
              </td>
              <td className="p-2">
                <input
                  type="text"
                  value={newCourse.name}
                  onChange={(e) =>
                    setNewCourse({ ...newCourse, name: e.target.value })
                  }
                  className="w-full border rounded py-2 px-3"
                />
              </td>
              <td className="p-2">
                <input
                  type="date"
                  value={newCourse.date}
                  onChange={(e) =>
                    setNewCourse({ ...newCourse, date: e.target.value })
                  }
                  className="w-full border rounded py-2 px-3"
                />
              </td>
              <td className="p-2">
                <input
                  type="date"
                  value={newCourse.nextRevision}
                  onChange={(e) =>
                    setNewCourse({ ...newCourse, nextRevision: e.target.value })
                  }
                  className="w-full border rounded py-2 px-3"
                />
              </td>
              <td className="p-2">
                <button
                  onClick={handleAdd}
                  className="bg-blue-500 text-white py-2 px-4 rounded"
                >
                  Add
                </button>
              </td>
            </tr>
          </tfoot>
        </table>
      </div>
    </div>
  );
};

export default CourseList;
