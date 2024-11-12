package com.maraloedev.ejemplo08_fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejemplo08_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bCargarFragments.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                // add -> agrega un fragmento
                // replace -> reemplaza un fragmento
                // remove -> elimina un fragmento

                add(R.id.fragmentContainerView, FragmentInicial())
                commit()
            }
        }

        binding.bCambiarFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, Fragment2())
                commit()
            }
        }
    }
}