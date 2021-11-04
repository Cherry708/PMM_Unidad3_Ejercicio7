package com.example.pmm_unidad3_ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.pmm_unidad3_ejercicio7.databinding.ActivityFechaNacimientoBinding


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


        //Se muestra por defecto
        binding.cbSeMuestra.isChecked = true
        binding.cbSeMuestra.setOnCheckedChangeListener {
                view, isChecked ->
            binding.calendario.isVisible = binding.cbSeMuestra.isChecked
        }

        var dia = ""
        var mes = ""
        var anno = ""
        binding.btnAceptar1.isEnabled = false
        binding.calendario.setOnDateChangeListener{
            view,year,month, dayOfMonth ->
            dia = dayOfMonth.toString()
            mes = month.toString()
            anno = year.toString()

            /*
            Aceptar solo esta habilitado una vez se escoge una fecha,
            para escoger una fecha es necesario checkear el checkbox.
            Por lo tanto, el boton solo estara activo cuando se haya mostrado
            el calendario y se haya seleccionado una fecha
             */
            binding.btnAceptar1.isEnabled = true
        }

        binding.btnAceptar1.setOnClickListener {
            val intentFecha = Intent(this, Horoscopo::class.java)
            intentFecha.putExtra("sexo", sexo)
            intentFecha.putExtra("nombre", nombre)

            intentFecha.putExtra("dia", dia)
            intentFecha.putExtra("mes", mes)
            intentFecha.putExtra("anno", anno)

            startActivity(intentFecha)
        }

    }
}