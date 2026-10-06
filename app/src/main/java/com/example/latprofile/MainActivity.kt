package com.example.latprofile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutEmail = findViewById<LinearLayout>(R.id.layoutEmail)
        val layoutPhone = findViewById<LinearLayout>(R.id.layoutPhone)
        val layoutRole = findViewById<LinearLayout>(R.id.layoutRole)
        val tvRole = findViewById<TextView>(R.id.tvRole)

        val roleLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val selectedRole = result.data?.getStringExtra("selectedRole")

                if (selectedRole != null) {
                    tvRole.text = selectedRole
                }
            }
        }

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

        layoutRole.setOnClickListener {
            val roleIntent = Intent(this, RoleActivity::class.java)
            roleLauncher.launch(roleIntent)
        }
    }
}