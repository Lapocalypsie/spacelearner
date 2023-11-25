"use client";

import Citation from "@/components/citation";
import CourseList from "@/components/cours";
import Container from "@/components/shared/container";
import ToDo from "@/components/todo";
import { Calendar } from "@/components/ui/calendar";
import React from "react";

import image from "@/public/SpaceBackground.jpg";

export default function Home() {
  const [date, setDate] = React.useState<Date | undefined>(new Date());

  return (
    <Container>
      <main>
        <h1 className="text-center text-black font-bold text-3xl mb-4 mt-8">
          Space Learning
        </h1>
        <div className="flex flex-wrap">
          <div className="w-full md:w-1/3 pr-0 md:pr-4 mb-4 md:mb-0 mt-4">
            <ToDo />
          </div>
          <div className="w-full md:w-1/3 pl-0 md:pl-4">
            <div className="mt-8">
              <Citation />
            </div>
            <div className="mb-8 md:mb-20 items-center">
              <div className="flex justify-center mb-8">
                <CourseList />
              </div>
              <Calendar
                mode="single"
                selected={date}
                onSelect={setDate}
                className="rounded-md border border-gray-300"
              />
            </div>
          </div>
          <div className="w-full md:w-1/3 pl-0 md:pl-4 mt-8">
            <div className="mx-4">
              {"Here will be the Profile User overviews"}
            </div>
          </div>
        </div>
      </main>
    </Container>
  );
}
