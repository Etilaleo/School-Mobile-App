package com.example.esmmobile.ui.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.esmmobile.databinding.FragmentPdfViewFragmetBinding
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle

class PdfViewFragment : Fragment() {

    private lateinit var binding: FragmentPdfViewFragmetBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentPdfViewFragmetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Getting name of clicked pdf
        val data = arguments
        val courseName = data?.getString("CourseName")

        Toast.makeText(requireContext(),"$courseName", Toast.LENGTH_LONG).show()

        // Load the PDF file from the assets folder
        binding.pdfView.fromAsset("software_engineering.pdf")
            .defaultPage(0)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .scrollHandle(DefaultScrollHandle(requireContext()))
            .enableAnnotationRendering(false)
            .load()
    }

}