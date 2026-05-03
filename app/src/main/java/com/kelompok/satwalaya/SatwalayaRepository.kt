package com.kelompok.satwalaya

import android.content.ContentValues
import android.content.Context

class SatwalayaRepository(context: Context) {
    private val db = SatwalayaDatabase(context)

    // ===== PENITIPAN =====
    fun getAllPenitipan(): List<Penitipan> {
        val list = mutableListOf<Penitipan>()
        val cursor = db.readableDatabase.query(
            SatwalayaDatabase.TABLE_PENITIPAN, null, null, null, null, null,
            "${SatwalayaDatabase.COL_PEN_TANGGAL} ASC"
        )
        cursor.use {
            while (it.moveToNext()) {
                list.add(Penitipan(
                    id = it.getInt(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_PEN_ID)),
                    namaPemilik = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_PEN_NAMA)),
                    namaHewan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_PEN_HEWAN)),
                    jenisHewan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_PEN_JENIS)),
                    tanggal = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_PEN_TANGGAL)),
                    jam = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_PEN_JAM)),
                    catatan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_PEN_CATATAN)),
                    status = it.getInt(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_PEN_STATUS))
                ))
            }
        }
        return list
    }

    fun addPenitipan(data: Penitipan): Long {
        val cv = ContentValues().apply {
            put(SatwalayaDatabase.COL_PEN_NAMA, data.namaPemilik)
            put(SatwalayaDatabase.COL_PEN_HEWAN, data.namaHewan)
            put(SatwalayaDatabase.COL_PEN_JENIS, data.jenisHewan)
            put(SatwalayaDatabase.COL_PEN_TANGGAL, data.tanggal)
            put(SatwalayaDatabase.COL_PEN_JAM, data.jam)
            put(SatwalayaDatabase.COL_PEN_CATATAN, data.catatan)
            put(SatwalayaDatabase.COL_PEN_STATUS, 0)
        }
        return db.writableDatabase.insert(SatwalayaDatabase.TABLE_PENITIPAN, null, cv)
    }

    fun deletePenitipan(id: Int) = db.writableDatabase.delete(
        SatwalayaDatabase.TABLE_PENITIPAN,
        "${SatwalayaDatabase.COL_PEN_ID} = ?",
        arrayOf(id.toString())
    )

    // ===== GROOMING =====
    fun getAllGrooming(): List<Grooming> {
        val list = mutableListOf<Grooming>()
        val cursor = db.readableDatabase.query(
            SatwalayaDatabase.TABLE_GROOMING, null, null, null, null, null,
            "${SatwalayaDatabase.COL_GRM_TANGGAL} ASC"
        )
        cursor.use {
            while (it.moveToNext()) {
                list.add(Grooming(
                    id = it.getInt(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_GRM_ID)),
                    namaPemilik = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_GRM_NAMA)),
                    namaHewan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_GRM_HEWAN)),
                    jenisHewan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_GRM_JENIS)),
                    tanggal = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_GRM_TANGGAL)),
                    jam = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_GRM_JAM)),
                    catatan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_GRM_CATATAN)),
                    status = it.getInt(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_GRM_STATUS))
                ))
            }
        }
        return list
    }

    fun addGrooming(data: Grooming): Long {
        val cv = ContentValues().apply {
            put(SatwalayaDatabase.COL_GRM_NAMA, data.namaPemilik)
            put(SatwalayaDatabase.COL_GRM_HEWAN, data.namaHewan)
            put(SatwalayaDatabase.COL_GRM_JENIS, data.jenisHewan)
            put(SatwalayaDatabase.COL_GRM_TANGGAL, data.tanggal)
            put(SatwalayaDatabase.COL_GRM_JAM, data.jam)
            put(SatwalayaDatabase.COL_GRM_CATATAN, data.catatan)
            put(SatwalayaDatabase.COL_GRM_STATUS, 0)
        }
        return db.writableDatabase.insert(SatwalayaDatabase.TABLE_GROOMING, null, cv)
    }

    fun deleteGrooming(id: Int) = db.writableDatabase.delete(
        SatwalayaDatabase.TABLE_GROOMING,
        "${SatwalayaDatabase.COL_GRM_ID} = ?",
        arrayOf(id.toString())
    )

    // ===== KONSULTASI =====
    fun getAllKonsultasi(): List<Konsultasi> {
        val list = mutableListOf<Konsultasi>()
        val cursor = db.readableDatabase.query(
            SatwalayaDatabase.TABLE_KONSULTASI, null, null, null, null, null,
            "${SatwalayaDatabase.COL_KON_TANGGAL} ASC"
        )
        cursor.use {
            while (it.moveToNext()) {
                list.add(Konsultasi(
                    id = it.getInt(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_KON_ID)),
                    namaPemilik = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_KON_NAMA)),
                    namaHewan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_KON_HEWAN)),
                    jenisHewan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_KON_JENIS)),
                    tanggal = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_KON_TANGGAL)),
                    jam = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_KON_JAM)),
                    catatan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_KON_CATATAN)),
                    status = it.getInt(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_KON_STATUS))
                ))
            }
        }
        return list
    }

    fun addKonsultasi(data: Konsultasi): Long {
        val cv = ContentValues().apply {
            put(SatwalayaDatabase.COL_KON_NAMA, data.namaPemilik)
            put(SatwalayaDatabase.COL_KON_HEWAN, data.namaHewan)
            put(SatwalayaDatabase.COL_KON_JENIS, data.jenisHewan)
            put(SatwalayaDatabase.COL_KON_TANGGAL, data.tanggal)
            put(SatwalayaDatabase.COL_KON_JAM, data.jam)
            put(SatwalayaDatabase.COL_KON_CATATAN, data.catatan)
            put(SatwalayaDatabase.COL_KON_STATUS, 0)
        }
        return db.writableDatabase.insert(SatwalayaDatabase.TABLE_KONSULTASI, null, cv)
    }

    fun deleteKonsultasi(id: Int) = db.writableDatabase.delete(
        SatwalayaDatabase.TABLE_KONSULTASI,
        "${SatwalayaDatabase.COL_KON_ID} = ?",
        arrayOf(id.toString())
    )

    // ===== VAKSINASI =====
    fun getAllVaksinasi(): List<Vaksinasi> {
        val list = mutableListOf<Vaksinasi>()
        val cursor = db.readableDatabase.query(
            SatwalayaDatabase.TABLE_VAKSINASI, null, null, null, null, null,
            "${SatwalayaDatabase.COL_VAK_TANGGAL} ASC"
        )
        cursor.use {
            while (it.moveToNext()) {
                list.add(Vaksinasi(
                    id = it.getInt(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_VAK_ID)),
                    namaPemilik = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_VAK_NAMA)),
                    namaHewan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_VAK_HEWAN)),
                    jenisHewan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_VAK_JENIS)),
                    tanggal = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_VAK_TANGGAL)),
                    jam = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_VAK_JAM)),
                    catatan = it.getString(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_VAK_CATATAN)),
                    status = it.getInt(it.getColumnIndexOrThrow(SatwalayaDatabase.COL_VAK_STATUS))
                ))
            }
        }
        return list
    }

    fun addVaksinasi(data: Vaksinasi): Long {
        val cv = ContentValues().apply {
            put(SatwalayaDatabase.COL_VAK_NAMA, data.namaPemilik)
            put(SatwalayaDatabase.COL_VAK_HEWAN, data.namaHewan)
            put(SatwalayaDatabase.COL_VAK_JENIS, data.jenisHewan)
            put(SatwalayaDatabase.COL_VAK_TANGGAL, data.tanggal)
            put(SatwalayaDatabase.COL_VAK_JAM, data.jam)
            put(SatwalayaDatabase.COL_VAK_CATATAN, data.catatan)
            put(SatwalayaDatabase.COL_VAK_STATUS, 0)
        }
        return db.writableDatabase.insert(SatwalayaDatabase.TABLE_VAKSINASI, null, cv)
    }

    fun deleteVaksinasi(id: Int) = db.writableDatabase.delete(
        SatwalayaDatabase.TABLE_VAKSINASI,
        "${SatwalayaDatabase.COL_VAK_ID} = ?",
        arrayOf(id.toString())
    )
}