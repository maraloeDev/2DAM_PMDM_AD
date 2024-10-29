package com.maraloedev.ejemplo05_llamandoaotrosactivities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo05_llamandoaotrosactivities.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {

    lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inflar el diseño y configurar el binding
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // Mostrar el dato recibido de MainActivity
        binding.tvDatoPasado.text = this.intent.getStringExtra("dato").toString()

        // Configurar el botón para devolver el dato a MainActivity
        binding.bVolverActivity1.setOnClickListener {
            val datoARetornar: String = binding.tietDatoARetornar.text.toString()
            setResult(RESULT_OK, intent.putExtra("datoARetornar", datoARetornar))
            finish() // Finalizar la actividad y devolver el resultado
        }
    }
}