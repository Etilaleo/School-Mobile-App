package com.example.esmmobile.viewmodels

import androidx.lifecycle.ViewModel
import com.example.esmmobile.R
import com.example.esmmobile.models.PdfCourseData

class CourseViewModel : ViewModel() {

    val courseList = ArrayList<PdfCourseData>()

    init {
        theList()
    }

    private fun theList() : ArrayList<PdfCourseData> {
        courseList.add(PdfCourseData("Software Engineering", "CME 401", R.drawable.remake_software_dev))
        courseList.add(PdfCourseData("Computer Programming", "CME 424", R.drawable.programming_language))
        return courseList
    }

}