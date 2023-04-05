package com.example.esmmobile.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.TextView
import com.example.esmmobile.R
import com.example.esmmobile.ui.mainScreen.EventsFragment

class CustomCalendarAdapter(context: Context) : ArrayAdapter<EventsFragment.CalendarDay>(context, R.layout.item_custom_calendar),
    ListAdapter {
    val evFragments = EventsFragment()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_custom_calendar, parent, false)

        val dayTextView = view.findViewById<TextView>(R.id.dayTextView)

        val calendarDay = getItem(position)
        if (calendarDay != null) {
            Log.d("CalenderString", calendarDay.dateString)
            dayTextView.text = calendarDay.dateString.substringAfterLast("-")


        }

        return view
    }
}