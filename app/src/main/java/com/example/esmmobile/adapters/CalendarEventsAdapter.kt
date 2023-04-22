package com.example.esmmobile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esmmobile.R
import com.example.esmmobile.models.CalendarEventData

class CalendarEventsAdapter(
    val context: Context,
    private val eventsList : ArrayList<CalendarEventData>
) : RecyclerView.Adapter<CalendarEventsAdapter.EventsViewHolder>(){

    inner class EventsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val text: TextView = view.findViewById(R.id.eventText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_events_calender, parent, false)
        return EventsViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        holder.text.text = eventsList[position].text
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }
}