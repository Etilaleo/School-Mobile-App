package com.example.esmmobile.ui.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.esmmobile.EventsList
import com.example.esmmobile.R
import com.example.esmmobile.adapters.CalendarEventsAdapter
import com.example.esmmobile.databinding.FragmentHomeBinding
import com.example.esmmobile.models.CalendarEventData
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var eventList = EventsList.theList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionBar()

        imageSlider()
        events()
        binding.eventsSeeMore.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_eventsFragment)
        }
    }

    private fun actionBar() {
        val actionBarTitle = getString(R.string.app_name)
        val actionBar  = (activity as AppCompatActivity).supportActionBar!!
        actionBar.title = "| $actionBarTitle"
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.show()
    }

    //Adding to the Image slider
    private fun imageSlider() {
        val imageList = arrayListOf(
            SlideModel(R.drawable.programming_language, "Programming Language", ScaleTypes.CENTER_CROP),
            SlideModel(R.drawable.software_development, "Software Development", ScaleTypes.CENTER_CROP),
            SlideModel(R.drawable.undergraduate_courses, ScaleTypes.CENTER_CROP),
        )

        binding.imageSlider.setImageList(imageList)
        binding.imageSlider.startSliding(3000L)
    }

    //Adding Events
    private fun events() {
        val newEventList = arrayListOf<CalendarEventData>()
        val today = SimpleDateFormat("yyyy-MM-d", Locale.getDefault())
        eventList.forEach {
            if (it.date == today.format(Calendar.getInstance().time)) {
                newEventList.add(it)
            }
        }
        val eventAdapter  = CalendarEventsAdapter(requireContext(), newEventList)
        binding.eventsForHomeRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = eventAdapter
        }
    }
}