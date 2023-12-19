import React, { FC, useEffect, useState } from "react";

interface CourseData {
  id: {
    timestamp: number;
    date: string;
  };
  nom: string;
  dateCreation: string;
  datesApprentissage: string[];
  status: boolean;
}

interface CourseProps {
  id: {
    timestamp: number;
    date: string;
  };
  name: string;
  date: string;
  status: boolean;
  nextRevision: string; // Add this line
  onToggle: (timestamp: number) => void;
  onRemove: (timestamp: number) => void;
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
  const isEvenRow = id.timestamp % 2 === 0;
  return (
    <tr className={`course ${isEvenRow ? "bg-gray-200" : "bg-white"}`}>
      <td className="p-2 text-center">
        <input
          type="checkbox"
          checked={status}
          onChange={() => onToggle(id.timestamp)}
          className="form-checkbox text-indigo-600 h-5 w-5"
        />
      </td>
      <td className="p-2 text-center">{name}</td>
      <td className="p-2 text-center">{date}</td>
      <td className="p-2 text-center">{nextRevision}</td>
      {/* New column for next revision */}
      <td className="p-2 text-center">
        <button
          onClick={() => onRemove(id.timestamp)}
          className="bg-red-500 text-white py-2 px-4 rounded cursor-pointer w-full hover:bg-red-600"
        >
          Supprimer
        </button>
      </td>
    </tr>
  );
};

const CourseList: React.FC = () => {
  const [courses, setCourses] = useState<CourseData[]>([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/v1/cours");
        const data = await response.json();
        setCourses(data);
        console.log("The data are : " + data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, []); // Empty dependency array ensures the effect runs only once (on mount)

  const [newCourse, setNewCourse] = useState({
    name: "",
    date: "",
    status: false,
    nextRevision: "", // Initialize next revision for new courses
  });

  const handleToggle = (timestamp: number) => {
    setCourses(
      courses.map((course) =>
        course.id.timestamp === timestamp
          ? { ...course, status: !course.status }
          : course
      )
    );
  };

  const handleRemove = async (timestamp: number) => {
    // Make a DELETE request to remove the course from the backend
    try {
      await fetch(`http://localhost:8080/api/v1/cours/${timestamp}`, {
        method: "DELETE",
      });
      setCourses(courses.filter((course) => course.id.timestamp !== timestamp));
    } catch (error) {
      console.error("Error deleting data:", error);
    }
  };

  const handleAdd = async () => {
    // Make a POST request to add the new course to the backend
    try {
      const toSend = { nom: newCourse.name, dateCreation: newCourse.date };
      const response = await fetch("http://localhost:8080/api/v1/cours", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(toSend),
      });
      const data = await response.json();

      // Add the new course to the local state
      setCourses([...courses, data]);

      // Clear the new course input fields
      setNewCourse({ name: "", date: "", status: false, nextRevision: "" });
    } catch (error) {
      console.error("Error adding data:", error);
    }
  };

  return (
    <div className="container mx-auto p-8 rounded-lg bg-white shadow-lg">
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
        <h4 className="font-semibold ml-3 text-xl">Mon planning de révision</h4>
      </div>
      <div className="overflow-x-auto rounded-lg shadow-lg">
        <table className="w-full">
          <thead>
            <tr className="bg-gray-900 text-white">
              <th className="p-2">Status</th>
              <th className="p-2">Cours</th>
              <th className="p-2">{"Date d'ajout"}</th>
              <th className="p-2">Prochaine révision</th>
              {/* New column header */}
              <th className="p-2">Action</th>
            </tr>
          </thead>
          <tbody>
            {courses.map((course) => (
              <Course
                key={course.id?.timestamp || 0}
                id={course.id || { timestamp: 0, date: "" }}
                name={course.nom}
                date={course.dateCreation}
                status={course.status}
                nextRevision={
                  (course.datesApprentissage && course.datesApprentissage[1]) ||
                  ""
                }
                onToggle={handleToggle}
                onRemove={handleRemove}
              />
            ))}
          </tbody>
          <tfoot className="">
            <tr className="border-t">
              <td className="p-2 text-center">
                <input
                  type="checkbox"
                  checked={newCourse.status}
                  onChange={() =>
                    setNewCourse({ ...newCourse, status: !newCourse.status })
                  }
                  className="form-checkbox text-indigo-600 h-5 w-5"
                />
              </td>
              <td className="p-2 text-center">
                <input
                  type="text"
                  value={newCourse.name}
                  onChange={(e) =>
                    setNewCourse({ ...newCourse, name: e.target.value })
                  }
                  className="w-full border rounded py-2 px-3"
                />
              </td>
              <td className="p-2 text-center">
                <input
                  type="date"
                  value={newCourse.date}
                  onChange={(e) =>
                    setNewCourse({ ...newCourse, date: e.target.value })
                  }
                  className="w-full border rounded py-2 px-3"
                />
              </td>
              <td className="p-2 text-center">{newCourse.nextRevision}</td>
              <td className="p-2 text-center">
                <button
                  onClick={handleAdd}
                  className="bg-green-700 text-white py-2 px-4 rounded w-full hover:bg-green-800"
                >
                  Ajouter
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
