package com.example.pixels.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pixels.R
import com.example.pixels.data.Subject

class SubjectsAdapter(
    private val listOfSubjects: List<Subject>
): RecyclerView.Adapter<SubjectsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvSubject = itemView.findViewById<TextView>(R.id.text_subject)
        val tvNumberOfNotes = itemView.findViewById<TextView>(R.id.text_number_of_notes)
        val tvDate = itemView.findViewById<TextView>(R.id.text_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_subject, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSubject = listOfSubjects[position]
        holder.apply {
            tvSubject.text = currentSubject.subjectName
            tvNumberOfNotes.text = currentSubject.numberOfNotes
            tvDate.text = currentSubject.date
        }
    }

    override fun getItemCount(): Int {
        return listOfSubjects.size
    }
}