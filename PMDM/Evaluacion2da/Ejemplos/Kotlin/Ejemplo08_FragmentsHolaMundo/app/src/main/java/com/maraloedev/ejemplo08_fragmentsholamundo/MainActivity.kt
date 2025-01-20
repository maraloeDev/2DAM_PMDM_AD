package com.maraloedev.ejemplo08_fragmentsholamundo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo08_fragmentsholamundo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del listener para el botón bCargarFragments
        binding.bCargarFragments.setOnClickListener {
            binding.button3.isEnabled = true
            // Iniciar una transacción de fragmentos para agregar FragmentInicial
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragmentContainerView, FragmentInicial())
                commit()
            }
        }

        // Configuración del listener para el botón button3
        binding.button3.setOnClickListener {
            // Iniciar una transacción de fragmentos para reemplazar con Fragment2
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, Fragment2())
                commit()
            }
        }
    }
}