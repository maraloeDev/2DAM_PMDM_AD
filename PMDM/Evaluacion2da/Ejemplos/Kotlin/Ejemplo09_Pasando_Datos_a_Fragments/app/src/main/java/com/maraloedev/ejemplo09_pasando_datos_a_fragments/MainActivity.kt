package com.maraloedev.ejemplo09_pasando_datos_a_fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo09_pasando_datos_a_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bPasarDatoFragment.setOnClickListener(){

            // Crear una instancia de MiFragment con el dato ingresado
            val fragment = MiFragment.newInstance(binding.tietDato.text.toString())
            // Iniciar una transacción para agregar el fragmento al contenedor
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, fragment).commit()
        }



    }
}