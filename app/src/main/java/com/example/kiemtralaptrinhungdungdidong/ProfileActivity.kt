package com.example.kiemtralaptrinhungdungdidong

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var tvProfileHeader: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvProfileHeader = findViewById(R.id.tvProfileHeader)
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSubjects = findViewById(R.id.lvSubjects)

        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL) ?: ""
        tvUserEmail.text = "Email: $email"

        btnLogout.setOnClickListener {
            finish()
        }

        val subjects = arrayOf(
            "Kotlin Programming",
            "XML Layout Design",
            "Git/GitHub Management",
            "Intent Processing",
            "Android Architecture"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            subjects
        )
        lvSubjects.adapter = adapter

        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                "Bạn đã chọn: ${subjects[position]}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
