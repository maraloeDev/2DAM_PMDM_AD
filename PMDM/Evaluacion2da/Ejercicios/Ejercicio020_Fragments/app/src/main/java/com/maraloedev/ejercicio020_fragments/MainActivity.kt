package com.maraloedev.ejercicio020_fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.maraloedev.ejercicio020_fragments.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), sumaContador {

    private lateinit var binding: ActivityMainBinding
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bIniciarContador.setOnClickListener {
            lifecycleScope.launch {
                for (i in 1..20) {
                    binding.tvNumeroAutomatico.text = i.toString()
                    delay(1000)
                }
            }
        }
    }

    override fun enviarContador(contador: Int) {
        var contador = contador
        contador++
        binding.tvNumeroAutomatico.text = contador.toString()
    }
}