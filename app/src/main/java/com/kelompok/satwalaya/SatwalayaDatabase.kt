package com.kelompok.satwalaya

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SatwalayaDatabase(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private const val DB_NAME = "satwalaya.db"
        private const val DB_VERSION = 1

        // Tabel Penitipan
        const val TABLE_PENITIPAN = "penitipan"
        const val COL_PEN_ID = "id"
        const val COL_PEN_NAMA = "nama_pemilik"
        const val COL_PEN_HEWAN = "nama_hewan"
        const val COL_PEN_JENIS = "jenis_hewan"
        const val COL_PEN_TANGGAL = "tanggal"
        const val COL_PEN_JAM = "jam"
        const val COL_PEN_CATATAN = "catatan"
        const val COL_PEN_STATUS = "status"

        // Tabel Grooming
        const val TABLE_GROOMING = "grooming"
        const val COL_GRM_ID = "id"
        const val COL_GRM_NAMA = "nama_pemilik"
        const val COL_GRM_HEWAN = "nama_hewan"
        const val COL_GRM_JENIS = "jenis_hewan"
        const val COL_GRM_TANGGAL = "tanggal"
        const val COL_GRM_JAM = "jam"
        const val COL_GRM_CATATAN = "catatan"
        const val COL_GRM_STATUS = "status"

        // Tabel Konsultasi
        const val TABLE_KONSULTASI = "konsultasi"
        const val COL_KON_ID = "id"
        const val COL_KON_NAMA = "nama_pemilik"
        const val COL_KON_HEWAN = "nama_hewan"
        const val COL_KON_JENIS = "jenis_hewan"
        const val COL_KON_TANGGAL = "tanggal"
        const val COL_KON_JAM = "jam"
        const val COL_KON_CATATAN = "catatan"
        const val COL_KON_STATUS = "status"

        // Tabel Vaksinasi
        const val TABLE_VAKSINASI = "vaksinasi"
        const val COL_VAK_ID = "id"
        const val COL_VAK_NAMA = "nama_pemilik"
        const val COL_VAK_HEWAN = "nama_hewan"
        const val COL_VAK_JENIS = "jenis_hewan"
        const val COL_VAK_TANGGAL = "tanggal"
        const val COL_VAK_JAM = "jam"
        const val COL_VAK_CATATAN = "catatan"
        const val COL_VAK_STATUS = "status"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Buat tabel Penitipan
        db.execSQL("""
            CREATE TABLE $TABLE_PENITIPAN (
                $COL_PEN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_PEN_NAMA TEXT NOT NULL,
                $COL_PEN_HEWAN TEXT NOT NULL,
                $COL_PEN_JENIS TEXT NOT NULL,
                $COL_PEN_TANGGAL TEXT NOT NULL,
                $COL_PEN_JAM TEXT NOT NULL,
                $COL_PEN_CATATAN TEXT,
                $COL_PEN_STATUS INTEGER NOT NULL DEFAULT 0
            )
        """.trimIndent())

        // Buat tabel Grooming
        db.execSQL("""
            CREATE TABLE $TABLE_GROOMING (
                $COL_GRM_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_GRM_NAMA TEXT NOT NULL,
                $COL_GRM_HEWAN TEXT NOT NULL,
                $COL_GRM_JENIS TEXT NOT NULL,
                $COL_GRM_TANGGAL TEXT NOT NULL,
                $COL_GRM_JAM TEXT NOT NULL,
                $COL_GRM_CATATAN TEXT,
                $COL_GRM_STATUS INTEGER NOT NULL DEFAULT 0
            )
        """.trimIndent())

        // Buat tabel Konsultasi
        db.execSQL("""
            CREATE TABLE $TABLE_KONSULTASI (
                $COL_KON_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_KON_NAMA TEXT NOT NULL,
                $COL_KON_HEWAN TEXT NOT NULL,
                $COL_KON_JENIS TEXT NOT NULL,
                $COL_KON_TANGGAL TEXT NOT NULL,
                $COL_KON_JAM TEXT NOT NULL,
                $COL_KON_CATATAN TEXT,
                $COL_KON_STATUS INTEGER NOT NULL DEFAULT 0
            )
        """.trimIndent())

        // Buat tabel Vaksinasi
        db.execSQL("""
            CREATE TABLE $TABLE_VAKSINASI (
                $COL_VAK_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_VAK_NAMA TEXT NOT NULL,
                $COL_VAK_HEWAN TEXT NOT NULL,
                $COL_VAK_JENIS TEXT NOT NULL,
                $COL_VAK_TANGGAL TEXT NOT NULL,
                $COL_VAK_JAM TEXT NOT NULL,
                $COL_VAK_CATATAN TEXT,
                $COL_VAK_STATUS INTEGER NOT NULL DEFAULT 0
            )
        """.trimIndent())

        insertSampleData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PENITIPAN")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_GROOMING")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_KONSULTASI")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_VAKSINASI")
        onCreate(db)
    }

    private fun insertSampleData(db: SQLiteDatabase) {
        // Sample Penitipan
        val penitipan = listOf(
            arrayOf("Budi Santoso", "Mochi", "Kucing", "1 Juni 2026", "09:00", "Tolong kasih makan 2x sehari"),
            arrayOf("Siti Rahayu", "Rocky", "Anjing", "5 Juni 2026", "10:00", "Alergi ayam"),
            arrayOf("Andi Pratama", "Cici", "Kelinci", "10 Juni 2026", "08:00", "-")
        )
        penitipan.forEach { p ->
            db.insert(TABLE_PENITIPAN, null, ContentValues().apply {
                put(COL_PEN_NAMA, p[0]); put(COL_PEN_HEWAN, p[1])
                put(COL_PEN_JENIS, p[2]); put(COL_PEN_TANGGAL, p[3])
                put(COL_PEN_JAM, p[4]); put(COL_PEN_CATATAN, p[5])
                put(COL_PEN_STATUS, 0)
            })
        }

        // Sample Grooming
        val grooming = listOf(
            arrayOf("Dewi Lestari", "Brownie", "Anjing", "2 Juni 2026", "13:00", "Potong rambut pendek"),
            arrayOf("Rina Marlina", "Panda", "Kucing", "6 Juni 2026", "14:00", "-"),
            arrayOf("Fajar Nugroho", "Loki", "Anjing", "8 Juni 2026", "10:00", "Mandi + potong kuku")
        )
        grooming.forEach { g ->
            db.insert(TABLE_GROOMING, null, ContentValues().apply {
                put(COL_GRM_NAMA, g[0]); put(COL_GRM_HEWAN, g[1])
                put(COL_GRM_JENIS, g[2]); put(COL_GRM_TANGGAL, g[3])
                put(COL_GRM_JAM, g[4]); put(COL_GRM_CATATAN, g[5])
                put(COL_GRM_STATUS, 0)
            })
        }

        // Sample Konsultasi
        val konsultasi = listOf(
            arrayOf("Siti Rahayu", "Rocky", "Anjing", "4 Juni 2026", "11:00", "Tidak mau makan"),
            arrayOf("Andi Pratama", "Cici", "Kelinci", "9 Juni 2026", "13:00", "Bulu rontok"),
            arrayOf("Budi Santoso", "Leo", "Kucing", "11 Juni 2026", "15:00", "Demam")
        )
        konsultasi.forEach { k ->
            db.insert(TABLE_KONSULTASI, null, ContentValues().apply {
                put(COL_KON_NAMA, k[0]); put(COL_KON_HEWAN, k[1])
                put(COL_KON_JENIS, k[2]); put(COL_KON_TANGGAL, k[3])
                put(COL_KON_JAM, k[4]); put(COL_KON_CATATAN, k[5])
                put(COL_KON_STATUS, 0)
            })
        }

        // Sample Vaksinasi
        val vaksinasi = listOf(
            arrayOf("Dewi Lestari", "Brownie", "Anjing", "3 Juni 2026", "09:00", "Vaksin rabies"),
            arrayOf("Fajar Nugroho", "Loki", "Anjing", "7 Juni 2026", "10:00", "Vaksin distemper"),
            arrayOf("Rina Marlina", "Panda", "Kucing", "12 Juni 2026", "11:00", "Vaksin FVRCP")
        )
        vaksinasi.forEach { v ->
            db.insert(TABLE_VAKSINASI, null, ContentValues().apply {
                put(COL_VAK_NAMA, v[0]); put(COL_VAK_HEWAN, v[1])
                put(COL_VAK_JENIS, v[2]); put(COL_VAK_TANGGAL, v[3])
                put(COL_VAK_JAM, v[4]); put(COL_VAK_CATATAN, v[5])
                put(COL_VAK_STATUS, 0)
            })
        }
    }
}