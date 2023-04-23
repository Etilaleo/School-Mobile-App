package com.example.esmmobile.ui.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.esmmobile.R
import com.example.esmmobile.databinding.FragmentNotificationsBinding
import java.util.Calendar
import java.util.Date


class NotificationsFragment : Fragment() {

    private lateinit var binding: FragmentNotificationsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actionBarTitle = getString(R.string.notifications)
        val actionBar  = (activity as AppCompatActivity).supportActionBar!!
        actionBar.title = actionBarTitle
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}