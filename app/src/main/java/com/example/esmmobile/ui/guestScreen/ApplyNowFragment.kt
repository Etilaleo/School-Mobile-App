package com.example.esmmobile.ui.guestScreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.esmmobile.R
import com.example.esmmobile.databinding.FragmentApplyNowBinding
import java.util.*

class ApplyNowFragment : Fragment() {

    private lateinit var binding: FragmentApplyNowBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentApplyNowBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = getString(R.string.apply_now)
        val actionbar = (activity as AppCompatActivity).supportActionBar!!
        actionbar.title = "| ${title.lowercase()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }}"

        binding.fillFormBtn.setOnClickListener {
            if (binding.formMaterialCard.visibility == View.GONE) {
                binding.formMaterialCard.visibility = View.VISIBLE
            }
            else {
                binding.formMaterialCard.visibility = View.GONE
            }


        }
    }
}