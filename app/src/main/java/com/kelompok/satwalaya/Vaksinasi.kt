package com.kelompok.satwalaya

data class Vaksinasi(
    val id: Int = 0,
    val namaPemilik: String,
    val namaHewan: String,
    val jenisHewan: String,
    val tanggal: String,
    val jam: String,
    val catatan: String,
    val status: Int = 0
) {
    fun getStatusText() = if (status == 1) "✅ Selesai" else "⏳ Terjadwal"
}