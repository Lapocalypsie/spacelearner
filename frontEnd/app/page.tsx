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
        <div className="flex items-center gap-x-6 bg-indigo-600 px-6 py-2.5 sm:px-3.5 sm:before:flex-1">
          <p className="text-sm leading-6 text-white">
            <a href="#">
              <strong className="font-semibold">Space Learner</strong>
              <svg viewBox="0 0 2 2" className="mx-2 inline h-0.5 w-0.5 fill-current" aria-hidden="true">
                <circle cx={1} cy={1} r={1} />
              </svg>
              L'application faîtes par des étudiants pour des étudiants
            </a>
          </p>
          <div className="flex flex-1 justify-end">
          </div>
        </div>
        <div className="container bg-gray-200">
          <div className="bg-white mt-8 p-8 rounded-lg shadow-lg">
            <section className="text-center">
              <div className="">
                <p>Ici un petit logo en légende</p>
                <h2 className="mb-8 text-5xl font-bold tracking-tight">
                  Space Learning <br />
                </h2>
                <a href="https://en.wikipedia.org/wiki/Spaced_learning" target="_blank" className="mb-2 inline-block rounded bg-indigo-600 px-12 pt-4 pb-3.5 text-sm font-medium uppercase leading-normal text-white shadow-[0_4px_9px_-4px_#3b71ca] transition duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] md:mr-2 md:mb-0"
                   data-te-ripple-init data-te-ripple-color="light" role="button">Tout savoir sur cette méthode</a>
              </div>
            </section>
          </div>

          <div className="">
            <div className="mt-8">
              <Citation />
            </div>
            <div className="mt-8  ">
              <ToDo />
            </div>
            <Calendar
                mode="single"
                selected={date}
                onSelect={setDate}
                className="rounded-md border border-gray-300 my-8"
            />
            <div className="">
              <CourseList />
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
