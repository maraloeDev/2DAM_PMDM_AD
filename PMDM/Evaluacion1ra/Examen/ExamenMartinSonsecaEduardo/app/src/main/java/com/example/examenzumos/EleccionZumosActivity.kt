package com.example.examenzumos

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenzumos.databinding.ActivityEleccionZumosBinding
import com.google.android.material.snackbar.Snackbar

class EleccionZumosActivity : AppCompatActivity() {
    lateinit var binding: ActivityEleccionZumosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEleccionZumosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var contadorNaranja = 0
        var contadorPina = 0
        var contadorFresa = 0
        var contadorMelocoton = 0

        val listaZumos: MutableList<PrecioZumos> = mutableListOf()

        binding.bNaranja.setOnClickListener {
            contadorNaranja++
            Snackbar.make(binding.root, "HAS PULSADO EL ZUMO DE NARANJA", Snackbar.LENGTH_SHORT)
                .show()
            val zumoNaranja = PrecioZumos("Naranja", 1)
            listaZumos.add(zumoNaranja)
        }

        binding.bPina.setOnClickListener {
            contadorPina++
            Snackbar.make(binding.root, "HAS PULSADO EL ZUMO DE PIÑA", Snackbar.LENGTH_SHORT).show()
            val zumoPina = PrecioZumos("Piña", 2)
            listaZumos.add(zumoPina)
        }

        binding.bFresa.setOnClickListener {
            contadorFresa++
            Snackbar.make(binding.root, "HAS PULSADO EL ZUMO DE FRESA", Snackbar.LENGTH_SHORT)
                .show()
            val zumoFresa = PrecioZumos("Fresa", 3)
            listaZumos.add(zumoFresa)
        }

        binding.bMelocoton.setOnClickListener {
            contadorMelocoton++
            Snackbar.make(binding.root, "HAS PULSADO EL ZUMO DE MELOCOTON", Snackbar.LENGTH_SHORT)
                .show()
            val zumoMelocoton = PrecioZumos("Melocoton", 4)
            listaZumos.add(zumoMelocoton)
        }

        binding.bFinalizar.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("listaZumos", listaZumos.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}