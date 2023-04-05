package com.example.esmmobile.ui.guestScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esmmobile.R
import com.example.esmmobile.adapters.UndergradCourseAdapter
import com.example.esmmobile.databinding.FragmentGuestUndergraduateCoursesBinding
import com.example.esmmobile.models.ChildUndergradCourseData
import com.example.esmmobile.models.UnderGradCourseData


class GuestUndergraduateCoursesFragment : Fragment() {

    private lateinit var binding : FragmentGuestUndergraduateCoursesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGuestUndergraduateCoursesBinding.inflate(layoutInflater)

        val title = "| ${getString(R.string.courses)}"
        val actionBar = (activity as AppCompatActivity).supportActionBar!!
        actionBar.title = title

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = mutableListOf<UnderGradCourseData>()

        val childListEngineering = mutableListOf<ChildUndergradCourseData>()
        childListEngineering.add(ChildUndergradCourseData("BEng. Computer Engineering"))
        childListEngineering.add(ChildUndergradCourseData("BEng. Electrical Engineering"))
        childListEngineering.add(ChildUndergradCourseData("BEng. Civil Engineering"))

        itemList.add(UnderGradCourseData("Faculty of Engineering", childListEngineering))
        itemList.add(UnderGradCourseData("Faculty of Management Science", childListEngineering))
        itemList.add(UnderGradCourseData("Faculty of Social Science", childListEngineering))
        itemList.add(UnderGradCourseData("Faculty of Pure & Applied Science", childListEngineering))
        itemList.add(UnderGradCourseData("Faculty of Education, Art & Humanities", childListEngineering))

        val parentAdapter = UndergradCourseAdapter(requireContext(), itemList)

        binding.parentUndergradRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = parentAdapter
        }
    }


}