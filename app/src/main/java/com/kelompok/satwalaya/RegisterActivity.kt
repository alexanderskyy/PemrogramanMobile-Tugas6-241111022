package com.kelompok.satwalaya

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kelompok.satwalaya.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        binding.btnRegister.setOnClickListener {
            val nama     = binding.etRegisNama.text.toString().trim()
            val email    = binding.etRegisEmail.text.toString().trim()
            val phone    = binding.etRegisPhone.text.toString().trim()
            val username = binding.etRegisUsername.text.toString().trim()
            val password = binding.etRegisPassword.text.toString().trim()

            when {
                nama.isEmpty() ->
                    binding.etRegisNama.error = "Nama tidak boleh kosong"
                email.isEmpty() ->
                    binding.etRegisEmail.error = "Email tidak boleh kosong"
                !email.contains("@") ->
                    binding.etRegisEmail.error = "Format email tidak valid"
                phone.isEmpty() ->
                    binding.etRegisPhone.error = "No. HP tidak boleh kosong"
                username.isEmpty() ->
                    binding.etRegisUsername.error = "Username tidak boleh kosong"
                password.isEmpty() ->
                    binding.etRegisPassword.error = "Password tidak boleh kosong"
                password.length < 6 ->
                    binding.etRegisPassword.error = "Password minimal 6 karakter"
                else -> {
                    sessionManager.saveLoginSession(
                        username = nama,
                        email    = email,
                        phone    = phone
                    )
                    Toast.makeText(
                        this,
                        "Akun berhasil dibuat! Selamat datang 🐾",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }
        }

        // Tombol balik ke Login
        binding.tvGoToLogin.setOnClickListener {
            finish()
        }
    }
}