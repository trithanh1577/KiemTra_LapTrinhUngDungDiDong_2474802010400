package com.example.kiemtralaptrinhungdungdidong

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var tvHeader: TextView
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvHeader = findViewById(R.id.tvHeader)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            validateLogin()
        }
    }

    private fun validateLogin() {
        val email = edtEmail.text.toString().trim()
        val password = edtPassword.text.toString()

        when {
            email.isEmpty() && password.isEmpty() -> {
                showError("Vui lòng nhập Email và Mật khẩu.")
            }
            email.isEmpty() -> {
                showError("Vui lòng nhập Email.")
            }
            password.isEmpty() -> {
                showError("Vui lòng nhập Mật khẩu.")
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                showError("Email không đúng định dạng.")
            }
            password.length < 6 -> {
                showError("Mật khẩu phải có ít nhất 6 ký tự.")
            }
            else -> {
                tvStatus.setTextColor(Color.parseColor("#2E7D32"))
                tvStatus.text = "Validation Successful!"

                val profileIntent = Intent(this, ProfileActivity::class.java)
                profileIntent.putExtra(EXTRA_EMAIL, email)
                startActivity(profileIntent)
            }
        }
    }

    private fun showError(message: String) {
        tvStatus.setTextColor(Color.parseColor("#C62828"))
        tvStatus.text = message
    }

    companion object {
        const val EXTRA_EMAIL = "extra_email"
    }
}

