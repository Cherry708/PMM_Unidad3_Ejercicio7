package com.example.pmm_unidad3_ejercicio7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmm_unidad3_ejercicio7.databinding.ActivityHoroscopoBinding

class Horoscopo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horoscopo)

        val binding = ActivityHoroscopoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = getIntent()
        val extras = intent.getExtras()

        val sexo = extras?.getString("sexo")
        val nombre = extras?.getString("nombre")

        val diaString = extras?.getString("dia")
        val mesString = extras?.getString("mes")
        val annoString = extras?.getString("anno")

        val dia = diaString?.toInt()
        val mes = mesString?.toInt()

        var horoscopo = ""
        when(mes) {
            1 -> if (dia!! >= 21) horoscopo = "Acuario"
            else horoscopo = "Capricornio"
            2 -> if (dia!! >= 19) horoscopo = "Piscis"
            else horoscopo = "Acuario"
            3 -> if (dia!! >= 21) horoscopo = "Aries"
            else horoscopo = "Piscis"
            4 -> if (dia!! >= 21) horoscopo = "Tauro"
            else horoscopo = "Piscis"
            5 -> if (dia!! >= 22) horoscopo = "Géminis"
            else horoscopo = "Tauro"
            6 -> if (dia!! >= 22) horoscopo = "Cancer"
            else horoscopo = "Géminis"
            7 -> if (dia!! >= 23) horoscopo = "Leo"
            else horoscopo = "Cancer"
            8 -> if (dia!! >= 24) horoscopo = "Virgo"
            else horoscopo = "Leo"
            9 -> if (dia!! >= 24) horoscopo = "Libra"
            else horoscopo = "Virgo"
            10 -> if (dia!! >= 24) horoscopo = "Escorpión"
            else horoscopo = "Libra"
            11 -> if (dia!! >= 23) horoscopo = "Sagitario"
            else horoscopo = "Escorpión"
            12 -> if (dia!! >= 22) horoscopo = "Capricornio"
            else horoscopo = ""
        }

        val presentacion = "Su horoscopo es $horoscopo"
        binding.tvPresentacion1.text =  presentacion
        binding.tvFecha.text = diaString.plus("/").plus(mesString).plus("/").plus(annoString)

        binding.btnSalir.setOnClickListener {
            System.exit(0)
        }


    }
}