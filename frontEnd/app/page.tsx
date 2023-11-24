import Calendar from "./components/calendar";
import Citation from "./components/citation";
import CourseList from "./components/cours";
import ToDo from "./components/todo";


export default function Home() {
  return (
    <main className="bg-white p-6">
      <h1 className="text-center text-black font-bold text-3xl mb-4 mt-8">Space Learning</h1>
      <div className="flex">
        <div className="w-1/3 pr-4">
          <ToDo />
        </div>
        <div className="w-2/3 pl-4 mb-24">
          <div className='mb-20 mt-16 mr-0'>
            <Citation />
          </div>
          <div className='mb-20'>
            <Calendar />
          </div>
          <div>
            <CourseList />
          </div>
        </div>
      </div>
    </main>
  );
}
