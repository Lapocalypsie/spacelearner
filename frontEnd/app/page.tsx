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
        <p>Ici on aura l'icone</p>
        <h1 className="text-center text-black font-bold text-3xl mb-4 mt-8">
          Space Learning
        </h1>
        <div className="mx-20">
          <div className="">
            <Citation />
          </div>
          <div className="">
            <ToDo />
          </div>
          <div className="flex justify-center mb-8">
            <CourseList />
          </div>
        </div>
        <Calendar
            mode="single"
            selected={date}
            onSelect={setDate}
            className="rounded-md border border-gray-300"
        />

          <div className="w-full md:w-1/3 pl-0 md:pl-4 mt-8">
            <div className="mx-4">
              {"Here will be the Profile User overviews"}
            </div>
          </div>
      </main>
    </Container>
  );
}
