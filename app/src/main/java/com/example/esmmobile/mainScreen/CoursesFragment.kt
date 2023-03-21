package com.example.esmmobile.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esmmobile.R
import com.example.esmmobile.adapters.PdfCourseAdapter
import com.example.esmmobile.databinding.FragmentCoursesBinding
import com.example.esmmobile.models.PdfCourseData

class CoursesFragment : Fragment() {

    private lateinit var binding : FragmentCoursesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCoursesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actionBarTitle = getString(R.string.courses)
        val actionBar  = (activity as AppCompatActivity).supportActionBar!!
        actionBar.title = "| $actionBarTitle"

        val courseList = arrayListOf<PdfCourseData>()
        courseList.add(PdfCourseData("Software Engineering", "CME 401", R.drawable.remake_software_dev))
        courseList.add(PdfCourseData("Computer Programming", "CME 424", R.drawable.programming_language))

        val pdfAdapter = PdfCourseAdapter(requireContext(), courseList)
        binding.courses.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pdfAdapter
        }

    }
}