import React from 'react';
import StarIcon from './icon';

function Citation() {
    const citationDay = "Productivity is never an accident. It is always the result of a commitment to excellence, intelligent planning, and focused effort."
    const author = "Paul J. Meyer"

    return (
        <div className="border border-purple-400 p-4 rounded-lg">
            <div className="flex items-center">
                <StarIcon />
                <p className="hover:font-bold my-2">{citationDay}</p>
            </div>

            <p className="mt-2"> - {author} </p>
        </div>
    );
}

export default Citation;
