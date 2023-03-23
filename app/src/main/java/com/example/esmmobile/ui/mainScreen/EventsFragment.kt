package com.example.esmmobile.ui.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.esmmobile.R
import com.example.esmmobile.databinding.FragmentEventsBinding

class EventsFragment : Fragment() {

    private lateinit var binding: FragmentEventsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEventsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = getString(R.string.events)
        val actionbar = (activity as AppCompatActivity).supportActionBar!!
        actionbar.title = "| $title"

        binding.calender.setOnDateChangeListener { _, year, month, dayOfMonth ->
            Toast.makeText(requireContext(), "$dayOfMonth-${month + 1}-$year", Toast.LENGTH_LONG).show()
        }
    }
}