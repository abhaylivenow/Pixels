package com.example.pixels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.pixels.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.menu.findItem(R.id.notes).setChecked(true)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.notes -> navigateToMyNotes()
                R.id.my_books -> navigateToMyBooks()
                R.id.download_books -> navigateToDownloadBooks()
            }
            true
        }
    }

    private fun navigateToMyBooks() {
        findNavController(R.id.fragmentContainerView).navigate(R.id.myBooksFragment)
    }

    private fun navigateToDownloadBooks() {
        findNavController(R.id.fragmentContainerView).navigate(R.id.downloadBooksFragment)
    }

    private fun navigateToMyNotes() {
        findNavController(R.id.fragmentContainerView).navigate(R.id.notesListFragment)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}