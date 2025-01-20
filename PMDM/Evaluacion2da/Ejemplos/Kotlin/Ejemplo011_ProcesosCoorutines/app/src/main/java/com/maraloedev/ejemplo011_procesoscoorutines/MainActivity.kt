package com.maraloedev.ejemplo011_procesoscoorutines

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejemplo011_procesoscoorutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bIniciarBarraProgreso.setOnClickListener(){
            binding.pbBarraProgreso.max=100

            CoroutineScope(Dispatchers.Default).launch{
                for (i in 0..100){
                    binding.pbBarraProgreso.progress=i
                    delay(100)
                }
            }
        }

    }
}