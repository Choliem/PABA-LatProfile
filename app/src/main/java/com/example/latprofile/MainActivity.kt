package com.example.latprofile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutEmail = findViewById<LinearLayout>(R.id.layoutEmail)
        val layoutPhone = findViewById<LinearLayout>(R.id.layoutPhone)

        layoutEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:sarah@school.edu")
            }

            startActivity(emailIntent)
        }

        layoutPhone.setOnClickListener {
            val phoneIntent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:+15559876547")
            )

            startActivity(phoneIntent)
        }
    }
}