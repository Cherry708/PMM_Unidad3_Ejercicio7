package com.example.pmm_unidad3_ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.pmm_unidad3_ejercicio7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAceptar.setOnClickListener {
            val nombre = binding.etNombre0.text.toString()
            val rbId = binding.rgSexo.checkedRadioButtonId
            val rbSexo = findViewById<RadioButton>(rbId)
            val sexo = rbSexo.text.toString()

            val intent = Intent(this, FechaNacimiento::class.java)
            intent.putExtra("sexo", sexo)
            intent.putExtra("nombre", nombre)
            startActivity(intent)
        }
    }
}