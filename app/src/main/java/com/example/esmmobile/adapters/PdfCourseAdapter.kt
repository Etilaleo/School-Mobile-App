package com.example.esmmobile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esmmobile.R
import com.example.esmmobile.models.PdfCourseData
import com.squareup.picasso.Picasso

class PdfCourseAdapter(
    val context: Context, private val pdfCourseList: ArrayList<PdfCourseData>
)
    :RecyclerView.Adapter<PdfCourseAdapter.PdfCourseViewHolder>() {

    inner class PdfCourseViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.coursePdfTitle)
        val code: TextView = itemView.findViewById(R.id.coursePdfCode)
        var image: ImageView = itemView.findViewById(R.id.coursePdfImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfCourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.courses_recycler, parent, false)
        return PdfCourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: PdfCourseViewHolder, position: Int) {
        val pos = pdfCourseList[position]

        //binding values together
        holder.title.text = pos.courseTitle
        holder.code.text = pos.courseCode
        Picasso.get().load(pos.courseImage).into(holder.image)

    }

    override fun getItemCount(): Int {
       return pdfCourseList.size
    }
}