package com.example.esmmobile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esmmobile.R
import com.example.esmmobile.models.ChildUndergradCourseData

class ChildUndergradCourseAdapter(
    val context: Context,
    private val theList : List<ChildUndergradCourseData>
) : RecyclerView.Adapter<ChildUndergradCourseAdapter.ChildUndergradCoursesViewHolder>() {

    inner class ChildUndergradCoursesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val item : TextView = itemView.findViewById(R.id.childUndergradItem)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChildUndergradCoursesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_child_guest_courses, parent, false)
        return ChildUndergradCoursesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildUndergradCoursesViewHolder, position: Int) {
        val child = theList[position]

        holder.item.text = child.item
    }

    override fun getItemCount(): Int {
        return  theList.size
    }
}