package com.example.pmm_unidad3_ejercicio7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.pmm_unidad3_ejercicio7.databinding.ActivityFechaNacimientoBinding
import android.widget.CompoundButton




class FechaNacimiento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fecha_nacimiento)

        val binding = ActivityFechaNacimientoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = getIntent()
        val extras = intent.getExtras()

        val sexo = extras?.getString("sexo")
        val nombre = extras?.getString("nombre")

        val presentacion = "Hola ${sexo?.lowercase()} $nombre"

        binding.tvPresentacion.text = presentacion

        binding.calendario.isVisible = false
        binding.cbSeMuestra.setOnCheckedChangeListener {
                checkBoxView, isChecked -> binding.calendario.isVisible = binding.cbSeMuestra.isChecked

        }


        binding.btnAceptar1.setOnClickListener {

        }

    }
}