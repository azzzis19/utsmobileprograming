package com.example.azisuts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = intent.getStringExtra("username")
        val welcomeMessage = "Welcome $username!"
        val welcomeTextView: TextView = findViewById(R.id.welcome_text)
        welcomeTextView.text = welcomeMessage

        val profileButton: Button = findViewById(R.id.profile_button)
        val cameraButton: Button = findViewById(R.id.camera_button)
        val logoutButton: Button = findViewById(R.id.logout_button)

        profileButton.setOnClickListener {
            Toast.makeText(this, "Username: $username", Toast.LENGTH_SHORT).show()
        }

        cameraButton.setOnClickListener {
            // Membuka aplikasi kamera
            val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }

        logoutButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
