package com.example.latprofile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RoleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_role)

        val btnAdmin = findViewById<Button>(R.id.btnAdmin)
        val btnUser = findViewById<Button>(R.id.btnUser)
        val btnGuest = findViewById<Button>(R.id.btnGuest)

        btnAdmin.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("selectedRole", "Admin")
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        btnUser.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("selectedRole", "User")
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        btnGuest.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("selectedRole", "Guest")
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}