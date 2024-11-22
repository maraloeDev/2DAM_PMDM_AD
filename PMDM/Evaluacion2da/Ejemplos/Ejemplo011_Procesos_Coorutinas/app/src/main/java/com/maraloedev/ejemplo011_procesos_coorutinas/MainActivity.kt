package com.maraloedev.ejemplo011_procesos_coorutinas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo011_procesos_coorutinas.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bIncrementar.setOnClickListener {

            binding.pbBarraDeProgreso.max = 100

            CoroutineScope(Dispatchers.Default).launch {

                for (i in 1..100) {
                    binding.pbBarraDeProgreso.progress = i
                    delay(100)
                }
            }
        }
    }
}