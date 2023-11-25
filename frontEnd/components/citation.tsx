import React from "react";
import StarIcon from "./icon";

function Citation() {
  const citationDay =
    "Productivity is never an accident. It is always the result of a commitment to excellence, intelligent planning, and focused effort.";
  const author = "Paul J. Meyer";

  return (
    <div className="border border-purple-400 p-4 rounded-lg mb-8 mt-8">
      <div className="flex items-center">
        <p className="text-2xl">🌟</p>
        <p className="hover:font-bold my-2 ml-4">{citationDay}</p>
      </div>

      <p className="ml-12 mt-2"> - {author} </p>
    </div>
  );
}

export default Citation;
