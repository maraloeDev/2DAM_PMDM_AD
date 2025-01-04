package com.maraloedev.ejercicio010_numeroasync

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejercicio010_numeroasync.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Creación de número aleatorio
        val random = Random


        binding.bTirarDado.setOnClickListener {
            //Cuando le des por primera vez al boton, se deshabilitara, para no probocar errores
            binding.bTirarDado.isEnabled = false

            CoroutineScope(Dispatchers.Main).launch {
                for (i in 1 ..100) {
                    delay(500)
                    binding.progressBar.progress = i

                    /**
                     * Creo el numero aleatorio, y si el numero aleatorio
                     * coincide con el numero ganador,
                     * se muestra el numero ganador, se habilita el boton
                     */
                    val numeroAleatorio = random.nextInt(1, 6)
                    val numeroGanador = random.nextInt(1, 6)
                    if (numeroAleatorio == numeroGanador) {
                        binding.tvNumeroAleatorio.text = "Numero Ganador $numeroGanador"
                        binding.bTirarDado.isEnabled=true
                        break

                    } else {
                    binding.tvNumeroAleatorio.text = numeroAleatorio.toString()
                    }
                }

            }



        }
    }
}