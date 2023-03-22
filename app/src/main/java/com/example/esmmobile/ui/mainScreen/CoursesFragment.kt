package com.example.esmmobile.ui.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esmmobile.R
import com.example.esmmobile.adapters.PdfCourseAdapter
import com.example.esmmobile.databinding.FragmentCoursesBinding
import com.example.esmmobile.viewmodels.CourseViewModel

class CoursesFragment : Fragment() {

    private lateinit var binding : FragmentCoursesBinding
    lateinit var courseListVm : CourseViewModel
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

        courseListVm = ViewModelProvider(this)[CourseViewModel::class.java]
        val pdfAdapter = PdfCourseAdapter(requireContext(), courseListVm.courseList)
        pdfAdapter.pdfCourseClick = {
            val bundle  = Bundle()
            bundle.putString("CourseName", it.courseTitle)
            Navigation.findNavController(view).navigate(R.id.action_coursesFragment_to_pdfViewFragment, bundle)
        }

        binding.courses.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pdfAdapter
        }

    }
}