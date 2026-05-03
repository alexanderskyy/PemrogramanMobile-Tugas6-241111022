package com.kelompok.satwalaya

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kelompok.satwalaya.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        // Jika sudah login sebelumnya, langsung ke MainActivity
        if (sessionManager.isLoggedIn()) {
            goToHome()
            return
        }

        // Tombol Login
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            when {
                username.isEmpty() -> {
                    binding.etUsername.error = "Username tidak boleh kosong"
                }
                password.isEmpty() -> {
                    binding.etPassword.error = "Password tidak boleh kosong"
                }
                password.length < 6 -> {
                    binding.etPassword.error = "Password minimal 6 karakter"
                }
                else -> {
                    sessionManager.saveLoginSession(
                        username = username,
                        email = "$username@gmail.com",
                        phone = "-"
                    )
                    Toast.makeText(this,
                        "Selamat datang, $username! 🐾",
                        Toast.LENGTH_SHORT).show()
                    goToHome()
                }
            }
        }

        // Pindah ke halaman Register
        binding.tvGoToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun goToHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}