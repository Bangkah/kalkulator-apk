package com.example.kalkulatorsatu

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Buat layout secara langsung (tanpa XML)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
        }

        val input1 = EditText(this).apply {
            hint = "Angka pertama"
            inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
        }

        val input2 = EditText(this).apply {
            hint = "Angka kedua"
            inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
        }

        val tombol = Button(this).apply {
            text = "Tambah"
        }

        val hasil = TextView(this).apply {
            textSize = 18f
            text = "Hasil: "
        }
        tombol.setOnClickListener {
            val angka1 = input1.text.toString().toDoubleOrNull()
            val angka2 = input2.text.toString().toDoubleOrNull()

            if (angka1 != null && angka2 != null) {
                hasil.text = "Hasil: ${angka1 + angka2}"
            } else {
                hasil.text = "Input tidak valid!"
            }
        }

        // Tambahkan semua elemen ke layout
        layout.addView(input1)
        layout.addView(input2)
        layout.addView(tombol)
        layout.addView(hasil)

        // Tampilkan layout sebagai isi tampilan
        setContentView(layout)
    }
}
