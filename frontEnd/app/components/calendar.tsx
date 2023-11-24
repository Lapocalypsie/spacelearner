"use client"
import React, { useState } from 'react';

const Calendar = () => {
    const [date, setDate] = useState(new Date());

    const handlePrevMonth = () => {
        setDate((prevDate) => new Date(prevDate.getFullYear(), prevDate.getMonth() - 1, 1));
    };

    const handleNextMonth = () => {
        setDate((prevDate) => new Date(prevDate.getFullYear(), prevDate.getMonth() + 1, 1));
    };

    const monthNames = [
        'January',
        'February',
        'March',
        'April',
        'May',
        'June',
        'July',
        'August',
        'September',
        'October',
        'November',
        'December',
    ];
    const daysOfWeek = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

    const daysInMonth = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();
    const firstDayOfMonth = new Date(date.getFullYear(), date.getMonth(), 1).getDay();

    const days = [];
    for (let i = 0; i < firstDayOfMonth; i++) {
        days.push(<div key={`empty-${i}`} className="empty-day"></div>);
    }
    for (let i = 1; i <= daysInMonth; i++) {
        days.push(<div key={`day-${i}`} className="day">{i}</div>);
    }

    return (
        <div className="w-2/3 p-4 border border-purple-400 rounded-lg">
            <div className="flex justify-between items-center mb-4">
                <button onClick={handlePrevMonth} className="text-xl text-purple-600 cursor-pointer">Prev</button>
                <h2 className="text-2xl text-purple-600 uppercase">{monthNames[date.getMonth()]} {date.getFullYear()}</h2>
                <button onClick={handleNextMonth} className="text-xl text-purple-600 cursor-pointer">Next</button>
            </div>
            <div className="grid grid-cols-7 gap-4">
                {daysOfWeek.map((day) => (
                    <div key={day} className="day-of-week font-bold">{day}</div>
                ))}
                {days}
            </div>
        </div>
    );
};

export default Calendar;
