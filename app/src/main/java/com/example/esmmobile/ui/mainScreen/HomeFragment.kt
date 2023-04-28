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

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    var eventList = EventsList.theList()
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
        actionBar.hide()
    }

    private fun imageSlider() {
        val imageList = arrayListOf(
            SlideModel(R.drawable.programming_language, "Programming Language", ScaleTypes.CENTER_CROP),
            SlideModel(R.drawable.software_development, "Software Development", ScaleTypes.CENTER_CROP),
            SlideModel(R.drawable.undergraduate_courses, ScaleTypes.CENTER_CROP),
        )

        binding.imageSlider.setImageList(imageList)
    }

    private fun events() {
        val eventAdapter  = CalendarEventsAdapter(requireContext(), eventList)
        binding.eventsForHomeRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = eventAdapter
        }
    }
}