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
    private lateinit var itemList : MutableList<UnderGradCourseData>
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

        itemList = mutableListOf()

        preparedData()
        val parentAdapter = UndergradCourseAdapter(requireContext(), itemList)
        binding.parentUndergradRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = parentAdapter
        }
    }

    private fun preparedData() {
        val childListEngineering = mutableListOf<ChildUndergradCourseData>()
        childListEngineering.add(ChildUndergradCourseData("BEng. Computer Engineering"))
        childListEngineering.add(ChildUndergradCourseData("BEng. Electrical Engineering"))
        childListEngineering.add(ChildUndergradCourseData("BEng. Civil Engineering"))

        itemList.add(UnderGradCourseData("Faculty of Engineering", childListEngineering, true))


        val childListMagSci = mutableListOf<ChildUndergradCourseData>()
        childListMagSci.add(ChildUndergradCourseData("BSc. Accounting"))
        childListMagSci.add(ChildUndergradCourseData("BSc. Banking and Finance"))
        childListMagSci.add(ChildUndergradCourseData("BSc. Marketing"))
        childListMagSci.add(ChildUndergradCourseData("BSc. Project Management"))
        childListMagSci.add(ChildUndergradCourseData("BSc. Transport and Logistics Management"))
        childListMagSci.add(ChildUndergradCourseData("BSc. Tourism and Hospitality Management"))
        childListMagSci.add(ChildUndergradCourseData("BSc. Human Resource Management"))

        itemList.add(UnderGradCourseData("Faculty of Management Science", childListMagSci))


        val childListSocialSci = mutableListOf<ChildUndergradCourseData>()
        childListSocialSci.add(ChildUndergradCourseData("BSc. Sociology"))
        childListSocialSci.add(ChildUndergradCourseData("BSc. Economics"))
        childListSocialSci.add(ChildUndergradCourseData("BSc. Political Science"))
        childListSocialSci.add(ChildUndergradCourseData("BSc. Public Administration"))
        childListSocialSci.add(ChildUndergradCourseData("BSc. Mass Communication"))
        childListSocialSci.add(ChildUndergradCourseData("BSc. Int'l Relations & Diplomacy"))

        itemList.add(UnderGradCourseData("Faculty of Social Science", childListSocialSci))


        val childListPure = mutableListOf<ChildUndergradCourseData>()
        childListPure.add(ChildUndergradCourseData("BSc. Computer Science"))
        childListPure.add(ChildUndergradCourseData("BSc. Microbiology"))
        childListPure.add(ChildUndergradCourseData("BSc. Biochemistry"))
        childListPure.add(ChildUndergradCourseData("BSc. Estate Management"))
        childListPure.add(ChildUndergradCourseData("BSc. Management and Information"))

        itemList.add(UnderGradCourseData("Faculty of Pure & Applied Science", childListPure))
    }


}