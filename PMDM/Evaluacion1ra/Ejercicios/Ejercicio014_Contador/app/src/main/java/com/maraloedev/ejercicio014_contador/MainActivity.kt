package com.maraloedev.ejercicio014_contador

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejercicio014_contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->

            if (result.resultCode == RESULT_OK) {

                binding.tvTotalContador.text = result.data?.getStringExtra("contador")
            }
        }

        binding.bEmpezarContar.setOnClickListener {
            val intent = Intent(this, ContadorActivity::class.java)
            launcher.launch(intent)
        }

        }
    }