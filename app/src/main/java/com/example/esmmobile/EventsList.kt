package com.example.esmmobile

import com.example.esmmobile.models.CalendarEventData

object EventsList {

    fun theList() : ArrayList<CalendarEventData> {
        val eventList = arrayListOf<CalendarEventData>(
            CalendarEventData("id el Fitr", "2023-04-21")
        )

        return eventList
    }
}