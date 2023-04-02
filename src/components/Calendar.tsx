import { useState } from "react";
import { motion } from "framer-motion"

const ChevronLeft = () => {
  return (
    <svg width="15" height="15" fill="currentColor" viewBox="0 0 24 24">
      <path fill="currentColor" d="M13.83 19a1 1 0 0 1-.78-.37l-4.83-6a1 1 0 0 1 0-1.27l5-6a1 1 0 0 1 1.54 1.28L10.29 12l4.32 5.36a1 1 0 0 1-.78 1.64z">
      </path>
    </svg>
  );
}

const ChevronRight = () => {
  return (
    <svg width="15" height="15" fill="currentColor" viewBox="0 0 24 24">
      <path fill="currentColor" d="M10 19a1 1 0 0 1-.64-.23a1 1 0 0 1-.13-1.41L13.71 12L9.39 6.63a1 1 0 0 1 .15-1.41a1 1 0 0 1 1.46.15l4.83 6a1 1 0 0 1 0 1.27l-5 6A1 1 0 0 1 10 19z">
      </path>
    </svg>
  )
}

function inSameDay(dateOne: Date, dateTwo: Date) {
  return dateOne.getFullYear() === dateTwo.getFullYear() && dateOne.getMonth() === dateTwo.getMonth() && dateOne.getDate() === dateTwo.getDate();
}

function isInMonth(month: Date, day: Date) {
  return month.getMonth() === day.getMonth()
}

function startOfMonth(date: Date): Date {
  return new Date(date.getFullYear(), date.getMonth(), 1);
}

function endOfMonth(date: Date): Date {
  return new Date(date.getFullYear(), date.getMonth() + 1, 0);
}

function nextMonth(date: Date): Date {
  return new Date(date.getFullYear(), date.getMonth() + 1);
}

function prevMonth(date: Date): Date {
  return new Date(date.getFullYear(), date.getMonth() - 1);
}

function nextDay(day: Date) {
  const next = new Date(day.getTime());
  next.setDate(next.getDate() + 1);
  return next;
}

function daysRange(from: Date, to: Date) {
  const range: Date[] = [];

  let i = new Date(from.getFullYear(), from.getMonth(), from.getDate());
  console.log("i", i)
  while (i <= to) {
    range.push(i);
    i = nextDay(i);
  }
  return range;
}

function startOfWeek(date: Date) {
  const startOfWeek = new Date(date.getFullYear(), date.getMonth());
  const WEEK_STARTS_ON = 1;
  const day = date.getDay();
  const diff = (day < WEEK_STARTS_ON ? -7 : 0) - (day - WEEK_STARTS_ON);
  console.log("diff", diff);
  startOfWeek.setDate(date.getDate() + diff);
  startOfWeek.setHours(0, 0, 0, 0);
  return startOfWeek;
}

function endOfWeek(date: Date) {
  const endOfWeek = new Date(date.getFullYear(), date.getMonth());

  const WEEK_STARTS_ON = 1;
  const day = date.getDay(); // from 0 to 6
  const diff = (day < WEEK_STARTS_ON ? -7 : 0) + 6 - (day - WEEK_STARTS_ON);
  endOfWeek.setDate(date.getDate() + diff);
  endOfWeek.setHours(23, 59, 59, 999);
  return endOfWeek;
}

function splitByWeeks(days: Date[]) {
  const weeks = new Map<number, Date[]>;
  for (const day of days) {
    const end = endOfWeek(day);
    const arr = weeks.get(end.getTime());
    if (arr !== undefined) {
      arr.push(day);
      continue;
    }
    if (arr === undefined) {
      const newArr = [day];
      weeks.set(end.getTime(), newArr);
      continue;
    }
  }
  return weeks
}

export function MyCalendar() {
  const [currentMonth, setCurrentMonth] = useState(new Date());

  const monthAndYear = new Intl.DateTimeFormat(undefined, {
    month: "short", year: "numeric"
  }).format(currentMonth);

  const firstDay = startOfMonth(currentMonth);
  const lastDay = endOfMonth(currentMonth);
  const calendarDays = splitByWeeks(daysRange(startOfWeek(firstDay), endOfWeek(lastDay)));
  const calendar = [...calendarDays.entries()];

  const [selectedDay, setSelectedDay] = useState(new Date());

  const getDateClassName = (date: Date) =>
    isInMonth(currentMonth, date)
      ? "px-2 py-3 text-center text-gray-800 cursor-pointer md:px-3 hover:text-blue-500"
      : "px-2 py-3 text-center text-gray-300 md:px-3 dark:text-gray-500"

  return (
    <div className="p-4 bg-white shadow-lg rounded-2xl dark:bg-gray-700">
      <div className="flex flex-wrap overflow-hidden">
        <div className="w-full rounded shadow-sm">
          <div className="flex items-center justify-between mb-4">
            <div className="text-xl font-bold text-left text-black dark:text-white">
              {monthAndYear}
            </div>
            <div className="flex space-x-4">
              <button
                onClick={() => setCurrentMonth(prev => prevMonth(prev))}
                className="p-2 text-white bg-blue-500 rounded-full transition-colors hover:bg-blue-600">
                <ChevronLeft />
              </button>
              <button
                onClick={() => setCurrentMonth(prev => nextMonth(prev))}
                className="p-2 text-white bg-blue-500 rounded-full transition-colors hover:bg-blue-600">
                <ChevronRight />
              </button>
            </div>
          </div>
          <div className="-mx-2">
            <table className="w-full dark:text-white">
              <thead>
                <tr>
                  <th className="px-2 py-3 md:px-3 ">
                    Пн
                  </th>
                  <th className="px-2 py-3 md:px-3 ">
                    Вт
                  </th>
                  <th className="px-2 py-3 md:px-3 ">
                    Ср
                  </th>
                  <th className="px-2 py-3 md:px-3 ">
                    Чт
                  </th>
                  <th className="px-2 py-3 md:px-3 ">
                    Пт
                  </th>
                  <th className="px-2 py-3 md:px-3 ">
                    Сб
                  </th>
                  <th className="px-2 py-3 md:px-3 ">
                    Вс
                  </th>
                </tr>
              </thead>
              <motion.tbody
                transition={{ ease: "easeOut", }}
                initial={{ opacity: 0, y: 400 }}
                animate={{ opacity: 1, y: 0 }}
                exit={{ opacity: 0 }}
                key={currentMonth.getTime()}
              >
                {calendar.map(([k, v]) => (
                  <tr
                    key={k}
                    className="text-gray-400 dark:text-gray-500">
                    {v.map(day => (
                      <td
                        key={day.getTime()}
                        className={getDateClassName(day)}
                        onClick={() => setSelectedDay(day)}
                      >
                        {
                          (new Date().getDate() === day.getDate() && isInMonth(currentMonth, day)) ? (
                            <span className="text-white px-4 py-2.5 bg-blue-500 rounded-full">
                              {day.getDate()}
                            </span>
                          ) : (
                            <span className={`${inSameDay(selectedDay, day) && "rounded-full border border-blue-300"} py-2.5 px-3`}>
                              {day.getDate()}
                            </span>
                          )
                        }
                      </td>
                    ))}
                  </tr>
                ))}
              </motion.tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

  )
}
