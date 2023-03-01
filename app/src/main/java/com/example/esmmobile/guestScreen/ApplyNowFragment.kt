package com.example.esmmobile.guestScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.esmmobile.databinding.FragmentApplyNowBinding

class ApplyNowFragment : Fragment() {

    private lateinit var binding: FragmentApplyNowBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentApplyNowBinding.inflate(layoutInflater)

        val actionBar = (activity as AppCompatActivity).supportActionBar!!
        actionBar.title = "Apply Now"

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}