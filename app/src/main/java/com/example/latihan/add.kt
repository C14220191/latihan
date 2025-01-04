package com.example.latihan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar
import java.util.Date

class add : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var _namaIn = findViewById<EditText>(R.id.inputNama)
        var _tanggalIn = findViewById<EditText>(R.id.inputTanggal)
        var _kategoriIn = findViewById<EditText>(R.id.inputKategori)
        var _deskripsiIn = findViewById<EditText>(R.id.inputDeskripsi)

        var _confirmBtn = findViewById<Button>(R.id.btnSave)
        _confirmBtn.setOnClickListener {
            var tAwalF = _tanggalIn.text.toString().split("/")
            val _tanggal: Date = Calendar.getInstance().apply {
                set(Calendar.YEAR, tAwalF[2].toInt())
                set(Calendar.MONTH, tAwalF[1].toInt() - 1)
                set(Calendar.DAY_OF_MONTH, tAwalF[0].toInt())

                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }.time

            var data = pengerjaan(
                _namaIn.text.toString(),
                _tanggal,
                _kategoriIn.text.toString(),
                _deskripsiIn.text.toString(),
                "Kerjakan"
            )

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("entryData", data)
            }

            startActivity(intent)
        }
    }
}