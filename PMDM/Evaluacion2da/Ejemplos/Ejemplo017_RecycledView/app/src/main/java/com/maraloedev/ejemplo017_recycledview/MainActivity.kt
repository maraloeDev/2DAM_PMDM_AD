package com.maraloedev.ejemplo017_recycledview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejemplo017_recycledview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val persona1 = Persona(ContextCompat.getDrawable(R.drawable.foto1)!!, "Eduardo1", 25, "609343434")
        val persona2 = Persona(ContextCompat.getDrawable(R.drawable.foto2)!!, "Eduardo2", 25, "609343434")
        val persona3 = Persona(ContextCompat.getDrawable(R.drawable.foto3)!!, "Eduardo3", 25, "609343434")

        val listaPersona = listOf(persona1, persona2, persona3)



    }
}