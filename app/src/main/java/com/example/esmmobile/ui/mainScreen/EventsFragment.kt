package com.example.esmmobile.ui.mainScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.esmmobile.R
import com.example.esmmobile.adapters.CustomCalendarAdapter
import com.example.esmmobile.databinding.FragmentEventsBinding
import java.text.SimpleDateFormat
import java.util.*


class EventsFragment : Fragment() {

    private lateinit var binding: FragmentEventsBinding

    lateinit var mCalendar: Calendar
    private lateinit var mAdapter: CustomCalendarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEventsBinding.inflate(layoutInflater)

        val title = getString(R.string.events)
        val actionbar = (activity as AppCompatActivity).supportActionBar!!
        actionbar.title = "| $title"

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCalendar = Calendar.getInstance()
        mAdapter = CustomCalendarAdapter(requireContext())

        setupCalendar()

        binding.calenderGrid.adapter = mAdapter
        binding.calenderGrid .setOnItemClickListener { parent, view, position, id ->
            val dateString = mAdapter.getItem(position)
            // Handle item click here
        }

        //Changing the month to different months.
        binding.previousMonth.setOnClickListener { previousMonth() }
        binding.nextMonth.setOnClickListener { nextMonth() }
    }

    private fun setupCalendar() {
        val monthYearFormat = SimpleDateFormat("MMMM yyyy", Locale.getDefault())

        // Set current month and year
        mCalendar.set(Calendar.DAY_OF_MONTH, 1)
        val monthYearString = monthYearFormat.format(mCalendar.time)
        binding.monthYear.text = monthYearString



        mAdapter.clear()
        getCalendarDays().forEach { mAdapter.add(it) }
    }

    private fun getCalendarDays(): MutableList<CalendarDay> {
        val days = mutableListOf<CalendarDay>()

        // Calculate starting day of week and number of days in month
        val startDayOfWeek = mCalendar.get(Calendar.DAY_OF_WEEK)
        val numberOfDaysInMonth = mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        // Add empty items for days before the first of the month
        for (i in 1 until startDayOfWeek) {
            days.add(CalendarDay(""))
        }

        // Add items for each day of the month
        for (i in 1..numberOfDaysInMonth) {
            val dateString = "${mCalendar.get(Calendar.YEAR)}-${mCalendar.get(Calendar.MONTH) + 1}-$i"
            days.add(CalendarDay(dateString))
        }

        return days
    }

    private fun previousMonth() {
        mCalendar.add(Calendar.MONTH, -1)
        setupCalendar()
    }

    private fun nextMonth() {
        mCalendar.add(Calendar.MONTH, 1)
        setupCalendar()
    }

    data class CalendarDay(val dateString: String)

}