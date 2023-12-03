import React from "react";

function Citation() {
  const citationDay =
    "Productivity is never an accident. It is always the result of a commitment to excellence, intelligent planning, and focused effort.";
  const author = "Paul J. Meyer";

  return (
          <div className="w-full mx-auto rounded-lg bg-white shadow-lg p-8 text-gray-800">
              <div className="w-full mb-10">
                  <div className="text-3xl text-indigo-500 text-left leading-tight h-3">“</div>
                  <p className="text-sm text-gray-600 text-center px-5">{citationDay}</p>
                  <div className="text-3xl text-indigo-500 text-right leading-tight h-3 -mt-3">”</div>
              </div>
              <div className="w-full">
                  <p className="text-md text-indigo-500 font-bold text-center">{author}</p>
              </div>
          </div>
  );
}

export default Citation;
