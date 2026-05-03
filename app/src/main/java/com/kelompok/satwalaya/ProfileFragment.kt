package com.kelompok.satwalaya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kelompok.satwalaya.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ✅ Ambil data dari SessionManager
        val sessionManager = SessionManager(requireContext())

        // ✅ Tampilkan data dari session (tidak hardcode lagi)
        binding.tvProfileName.text = sessionManager.getUsername()
        binding.tvProfileEmail.text = sessionManager.getEmail()
        binding.tvInfoName.text = sessionManager.getUsername()
        binding.tvInfoEmail.text = sessionManager.getEmail()
        binding.tvInfoPhone.text = sessionManager.getPhone()

        // Tombol Edit Profil
        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(requireContext(),
                "Fitur edit profil",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Tombol Logout dengan konfirmasi dialog
        binding.btnLogout.setOnClickListener {
            androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi Keluar")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Keluar") { _, _ ->
                    sessionManager.clearSession()
                    val intent = android.content.Intent(
                        requireContext(),
                        LoginActivity::class.java
                    )
                    intent.flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK or
                            android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton("Batal", null)
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}