package com.example.thekeyapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thekeyapp.database.KeyDatabase
import com.example.thekeyapp.repository.KeyRepository
import com.example.thekeyapp.viewmodel.KeyViewModel
import com.example.thekeyapp.viewmodel.KeyViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var keyViewModel: KeyViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupViewModel()
    }

    private fun setupViewModel() {
        val keyRepository = KeyRepository(KeyDatabase(this))
        val viewModelProviderFactory = KeyViewModelFactory(application, keyRepository)
        keyViewModel = ViewModelProvider(this, viewModelProviderFactory)[KeyViewModel::class.java]
    }
}