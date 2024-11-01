package com.maraloedev.exameneduardomartinsonsecaencasa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.exameneduardomartinsonsecaencasa.databinding.ActivityEleccionZumosBinding

class EleccionZumosActivity : AppCompatActivity() {
    lateinit var binding: ActivityEleccionZumosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEleccionZumosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var precioTotal = 0
        val zumosElegidos: MutableList<precioZumos> = mutableListOf()

        binding.bNaranja.setOnClickListener {
            zumosElegidos.add(precioZumos("Naranja", 1))
            precioTotal += 1
        }
        binding.bPina.setOnClickListener {
            zumosElegidos.add(precioZumos("Piña", 2))
            precioTotal += 2
        }
        binding.bFresa.setOnClickListener {
            zumosElegidos.add(precioZumos("Fresa", 3))
            precioTotal += 3
        }
        binding.bMelocoton.setOnClickListener {
            zumosElegidos.add(precioZumos("Melocoton", 4))
            precioTotal += 4
        }

        binding.bFinalizar.setOnClickListener {
            val intent = Intent().apply {
                putParcelableArrayListExtra("zumosElegidos", ArrayList(zumosElegidos))
                putExtra("precioTotal", precioTotal)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
