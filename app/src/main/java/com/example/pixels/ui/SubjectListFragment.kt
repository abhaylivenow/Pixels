package com.example.pixels.ui

import android.app.AlertDialog
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pixels.adapter.SubjectsAdapter
import com.example.pixels.data.Subject
import com.example.pixels.databinding.FragmentNotesListBinding
import java.text.SimpleDateFormat
import java.util.*


class SubjectListFragment : Fragment() {

    val sdf = SimpleDateFormat("dd/M/yyyy")
    private lateinit var binding: FragmentNotesListBinding
    private var listOfSubjects = mutableListOf<Subject>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesListBinding.inflate(inflater,container,false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvNotes.apply {
            layoutManager = StaggeredGridLayoutManager(2,1)
            adapter = SubjectsAdapter(listOfSubjects,context)
        }

        binding.btnAddSubject.setOnClickListener {
            initAddSubjectFlow()
        }

        if(listOfSubjects.size > 0){
            binding.textNoSubject.visibility = View.GONE
        }
    }

    private fun initAddSubjectFlow() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Add a Subject")

        val edtSubjectName = EditText(requireContext())
        edtSubjectName.hint = "Subject Name"
        edtSubjectName.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(edtSubjectName)

        builder.setPositiveButton("Add") { _, _ ->
            addSubject(subjectName = edtSubjectName.text.toString())
        }
        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }

        builder.show()
    }

    private fun addSubject(subjectName: String) {
        listOfSubjects.add(
            Subject(
                subjectName = subjectName,
                numberOfNotes = "No notes yet.",
                date =sdf.format(Date())
            )
        )
    }
}