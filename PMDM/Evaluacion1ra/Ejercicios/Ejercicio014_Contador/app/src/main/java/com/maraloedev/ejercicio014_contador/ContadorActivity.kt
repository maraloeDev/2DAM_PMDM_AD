package com.maraloedev.ejercicio014_contador

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejercicio014_contador.databinding.ActivityContadorBinding

class ContadorActivity : AppCompatActivity() {
    lateinit var binding: ActivityContadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contador)
        binding = ActivityContadorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var contador = 0
        binding.bContar.setOnClickListener {
            contador++
            binding.tvContar.text = contador.toString()

        }

        binding.bVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("contador", binding.tvContar.text)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}