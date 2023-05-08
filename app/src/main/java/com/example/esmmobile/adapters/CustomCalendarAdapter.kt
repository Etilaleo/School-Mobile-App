package com.example.esmmobile.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import com.example.esmmobile.R
import com.example.esmmobile.models.CalendarDay
import com.example.esmmobile.ui.mainScreen.EventsFragment
import java.text.SimpleDateFormat
import java.util.*

class CustomCalendarAdapter(context: Context)
    : ArrayAdapter<CalendarDay>(context, R.layout.item_custom_calendar), ListAdapter {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_custom_calendar, parent, false)

        val dayTextView = view.findViewById<TextView>(R.id.dayTextView)
        val eventMarker = view.findViewById<ImageView>(R.id.eventMarker)

        val calendarDay = getItem(position)
        if (calendarDay != null ) {
            val presentDate = SimpleDateFormat("yyyy-MM-d", Locale.getDefault())

            dayTextView.setBackgroundColor(Color.WHITE)
            eventMarker.visibility = View.GONE

            if (presentDate.format(Calendar.getInstance().time) == calendarDay.dateString) {
                dayTextView.text = calendarDay.dateString.substringAfterLast("-")
                dayTextView.setBackgroundResource(R.drawable.calender_day_background)
                dayTextView.setTextColor(Color.WHITE)
            }
            else {
                dayTextView.text = calendarDay.dateString.substringAfterLast("-")
            }
            //setting events marker
            val fragment = EventsFragment()
            fragment.eventList.forEach {
                if (it.date == calendarDay.dateString && it.date != presentDate.format(Calendar.getInstance().time)) {
                    eventMarker.visibility = View.VISIBLE
                }
            }
        }

        return view
    }
}