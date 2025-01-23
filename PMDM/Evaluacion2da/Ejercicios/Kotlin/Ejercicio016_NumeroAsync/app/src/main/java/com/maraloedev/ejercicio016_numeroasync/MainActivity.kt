package com.maraloedev.ejercicio016_numeroasync

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejercicio016_numeroasync.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bStart.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                binding.bStart.isEnabled = false
                for (i in 1..100) {

                    val nAleatorio = Random.nextInt(1, 6)
                    val nAleatorioAcertar = Random.nextInt(1, 6)
                    binding.tvNumeroAleatorio.text = Random.nextInt(1, 6).toString()
                    delay(2000)

                    if (nAleatorio == nAleatorioAcertar) {
                        binding.tvNumeroAleatorio.text = "Numero ganador $nAleatorio"
                        break
                    }

                }
                binding.bStart.isEnabled = true
            }
        }
    }
}