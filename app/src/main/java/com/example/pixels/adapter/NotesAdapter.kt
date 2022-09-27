package com.example.pixels.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pixels.R
import com.example.pixels.data.Notes

class NotesAdapter(
    private val listOfNotes: List<Notes>,
    private val context: Context
) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvNotesHeading = itemView.findViewById<TextView>(R.id.text_heading)
        val tvNotesDescription = itemView.findViewById<TextView>(R.id.text_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_notes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNotes = listOfNotes[position]
        holder.apply {
            tvNotesHeading.text = currentNotes.noteHeading
            tvNotesDescription.text = currentNotes.shortDescription
            itemView.setOnClickListener {
                Toast.makeText(context, "Notes clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfNotes.size
    }
}