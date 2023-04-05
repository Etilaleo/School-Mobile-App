package com.example.esmmobile.models

data class UnderGradCourseData(
    val item : String,
    val childList : List<ChildUndergradCourseData>,
    var expanded : Boolean = false
)
