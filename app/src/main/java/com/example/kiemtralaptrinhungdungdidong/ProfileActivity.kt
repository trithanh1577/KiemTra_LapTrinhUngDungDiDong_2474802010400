package com.example.kiemtralaptrinhungdungdidong

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var tvProfileHeader: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvProfileHeader = findViewById(R.id.tvProfileHeader)
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)

        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL) ?: ""
        tvUserEmail.text = "Email: $email"

        btnLogout.setOnClickListener {
            finish()
        }
    }
}
