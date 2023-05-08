package com.example.esmmobile

import com.example.esmmobile.models.CalendarEventData

object EventsList {

    fun theList() : ArrayList<CalendarEventData> {
        val eventList = arrayListOf<CalendarEventData>(
            CalendarEventData("1st Semester Resumption and Registration", "2022-8-15"),
            CalendarEventData("Registration of Courses/ French Classes", "2022-08-15"),
            CalendarEventData("Commencement of Other Lectures", "2022-09-5"),
            CalendarEventData("Lecture Ends", "2022-11-4"),
            CalendarEventData("Excursions", "2022-11-11"),
            CalendarEventData("Music Festival and Other Activities", "2022-11-18"),
            CalendarEventData("Mid Semester Test Begins", "2022-12-5"),
            CalendarEventData("Christmas Break Begins", "2022-12-16"),
            CalendarEventData("1st Semester Examinations", "2023-01-9"),
            CalendarEventData("2nd Semester Resumption and Registration", "2023-01-30"),
            CalendarEventData("Lectures Free Week", "2023-03-13"),
            CalendarEventData("Mid-Semester Test", "2023-03-20"),
            CalendarEventData("Easter Break", "2023-04-5"),
            CalendarEventData("Easter Break", "2023-04-5"),
            CalendarEventData("Lecture Continues", "2023-04-11"),
            CalendarEventData("Id El Fitr", "2023-04-21"),
            CalendarEventData("Lecture Continues", "2023-04-25"),
            CalendarEventData("2nd Semester Examination Begins", "2023-05-8"),
            CalendarEventData("Project Defence", "2023-05-22"),
            CalendarEventData("Project Defence", "2023-05-23"),
            CalendarEventData("Project Defence", "2023-05-24"),
            CalendarEventData("Project Defence", "2023-05-25"),
            CalendarEventData("Project Defence", "2023-05-26"),
            CalendarEventData("Summer Classes Begins", "2023-06-5"),
            CalendarEventData("Summer Examinations", "2023-07-31"),
        )

        return eventList
    }
}