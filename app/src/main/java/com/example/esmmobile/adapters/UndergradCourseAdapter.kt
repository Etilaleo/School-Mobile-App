package com.example.esmmobile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esmmobile.R
import com.example.esmmobile.models.UnderGradCourseData

class UndergradCourseAdapter(
    val context: Context,
    private val undergradList: List<UnderGradCourseData>
) : RecyclerView.Adapter<UndergradCourseAdapter.UndergradViewHolder>() {

    inner class UndergradViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val item : TextView = itemView.findViewById(R.id.undergradItem)
        val childRecycler : RecyclerView = itemView.findViewById(R.id.childUndergradRecycler)
        val parentLayout : ConstraintLayout = itemView.findViewById(R.id.parentLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UndergradViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_guest_courses, parent, false)
        return UndergradViewHolder(view)
    }

    override fun onBindViewHolder(holder: UndergradViewHolder, position: Int) {
        val parent = undergradList[position]
        holder.item.text = parent.item

        val childList = parent.childList
        val childAdapter = ChildUndergradCourseAdapter(context, childList)
        holder.childRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = childAdapter
        }

        //Creating the expanding functionality
        holder.childRecycler.visibility = if (parent.expanded) View.VISIBLE else View.GONE

        holder.parentLayout.setOnClickListener {
            //Creating this function to collapse other opened layout when one is clicked
            collapseOtherOpened(position)

            parent.expanded = !parent.expanded
            notifyItemChanged(position)
        }
    }

    private fun collapseOtherOpened(position: Int) {

        val item = undergradList.indexOfFirst {
            it.expanded
        }

        if (item >= 0 && item != position) {
            undergradList[item].expanded = false
            notifyItemChanged(item)
        }
    }

    override fun getItemCount(): Int {
        return undergradList.size
    }
}