import React, { useEffect } from "react";

function Citation() {
  // Define the type of the citation state, allowing it to be null initially
  const [citation, setCitation] = React.useState<{ id: number; text: string } | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/v1/quotes/randomquote");
        const data = await response.json();
        
        // Make sure to handle the case when 'data' is null
        setCitation(data || null);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="w-full mx-auto rounded-lg bg-white shadow-lg p-8 text-gray-800">
      <div className="w-full mb-10">
        <div className="text-3xl text-indigo-500 text-left leading-tight h-3">“</div>
        
        {citation && (
          <>
            <p className="text-lg text-gray-600 text-center px-5">Citation Numéro : {citation.id}</p>
            <p className="text-lg text-gray-600 text-center px-5">{citation.text}</p>
          </>
        )}
        
        <div className="text-3xl text-indigo-500 text-right leading-tight h-3 -mt-3">”</div>
      </div>
      
      <div className="w-full">
        <p className="text-md text-indigo-500 font-bold text-center">Unknonw Author</p>
      </div>
    </div>
  );
}

export default Citation;
