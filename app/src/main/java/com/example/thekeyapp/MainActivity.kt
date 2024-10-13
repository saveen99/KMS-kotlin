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

class MainActivity : AppCompatActivity() {
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

        // Reference to the button that will trigger the popup
        val showPopupButton = findViewById<Button>(R.id.show_popup_button)

        showPopupButton.setOnClickListener {
            // Inflate the popup_layout.xml
            val inflater: LayoutInflater = layoutInflater
            val popupView: View = inflater.inflate(R.layout.fragment_active_key_details, null)

            // Create the PopupWindow
            val popupWindow = PopupWindow(
                popupView,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
                true // Focusable
            )

            // Show the popup window at the center
            popupWindow.showAtLocation(it, Gravity.CENTER, 0, 0)

            // Close button inside the popup
            val closeButton = popupView.findViewById<Button>(R.id.close_button)
            closeButton.setOnClickListener {
                popupWindow.dismiss() // Close the popup window
            }
        }
    }
}