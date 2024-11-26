package com.maraloedev.examenandroid_parte3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.maraloedev.examenandroid_parte3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fragmentRegistro = Fragment_Registro()
    private val fragmentUsuarios = Fragment_Usuarios()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set default fragment
        replaceFragment(fragmentRegistro)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_registro -> replaceFragment(fragmentRegistro)
                R.id.nav_usuarios -> replaceFragment(fragmentUsuarios)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }

    fun getNumUsuariosRegistrados(): Int {
        return fragmentRegistro.getUsuariosRegistradosSize()
    }
}