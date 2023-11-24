"use client"

import React, { useState } from 'react';

const Course = ({ name, date, status, onToggle }) => {
    return (
        <tr className={`course ${status ? 'completed' : ''}`}>
            <td>
                <input
                    type="checkbox"
                    checked={status}
                    onChange={onToggle}
                    className="form-checkbox text-indigo-600 h-5 w-5"
                />
            </td>
            <td className="px-4 py-2">{name}</td>
            <td className="px-4 py-2">{date}</td>
        </tr>
    );
};

const CourseList = () => {
    const [courses, setCourses] = useState([
        { id: 1, name: 'Math', date: '2022-01-01', status: false },
        { id: 2, name: 'Science', date: '2022-01-02', status: true },
        { id: 3, name: 'History', date: '2022-01-03', status: false },
    ]);

    const [newCourse, setNewCourse] = useState({ name: '', date: '', status: false });

    const handleToggle = (id) => {
        setCourses(
            courses.map((course) =>
                course.id === id ? { ...course, status: !course.status } : course
            )
        );
    };

    const handleRemove = (id) => {
        setCourses(courses.filter((course) => course.id !== id));
    };

    const handleAdd = () => {
        const newId = Math.max(...courses.map((course) => course.id), 0) + 1;
        setCourses([...courses, { ...newCourse, id: newId }]);
        setNewCourse({ name: '', date: '', status: false });
    };

    return (
        <div className="container mx-auto py-4">
            <h1 className="font-bold text-2xl mb-4">Mes revisions</h1>
            <table className="w-full">
                <thead>
                    <tr className="bg-gray-100">
                        <th className="px-4 py-2">Status</th>
                        <th className="px-4 py-2">Course</th>
                        <th className="px-4 py-2">Date</th>
                        <th className="px-4 py-2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    {courses.map((course) => (
                        <tr key={course.id} className="border-b">
                            <td className="px-4 py-2">
                                <Course
                                    status={course.status}
                                    onToggle={() => handleToggle(course.id)}
                                />
                            </td>
                            <td className="px-4 py-2">{course.name}</td>
                            <td className="px-4 py-2">{course.date}</td>
                            <td className="px-4 py-2">
                                <button
                                    onClick={() => handleRemove(course.id)}
                                    className="text-red-500"
                                >
                                    Remove
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
                <tfoot>
                    <tr className="border-t">
                        <td className="px-4 py-2">
                            <input
                                type="checkbox"
                                checked={newCourse.status}
                                onChange={() => setNewCourse({ ...newCourse, status: !newCourse.status })}
                                className="form-checkbox text-indigo-600 h-5 w-5"
                            />
                        </td>
                        <td className="px-4 py-2">
                            <input
                                type="text"
                                value={newCourse.name}
                                onChange={(e) => setNewCourse({ ...newCourse, name: e.target.value })}
                                className="w-full border rounded py-2 px-3"
                            />
                        </td>
                        <td className="px-4 py-2">
                            <input
                                type="date"
                                value={newCourse.date}
                                onChange={(e) => setNewCourse({ ...newCourse, date: e.target.value })}
                                className="w-full border rounded py-2 px-3"
                            />
                        </td>
                        <td className="px-4 py-2">
                            <button onClick={handleAdd} className="bg-blue-500 text-white py-2 px-4 rounded">
                                Add
                            </button>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>
    );
};

export default CourseList;
