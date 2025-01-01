package com.maraloedev.ejemplo06_llamandoaotrosactivitiesconparcelable

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejemplo06_llamandoaotrosactivitiesconparcelable.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDatoPasado.text = this.intent.getStringExtra("dato").toString()

        binding.bIrAlSegundoActivity.setOnClickListener {

            var datoADevolver = binding.tietMandarDato.text.toString()
            setResult(RESULT_OK, intent.putExtra(datoADevolver, datoADevolver))
            finish()
        }



    }
}