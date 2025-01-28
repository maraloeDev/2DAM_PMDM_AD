package com.maraloedev.ejercicio018_sharedpreferences_y_sqlite_y_fragments

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.ejercicio018_sharedpreferences_y_sqlite_y_fragments.databinding.ActivityMainBinding
import utils.ConexionBD
import utils.TablaUsuario

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bd = Room.databaseBuilder(this, ConexionBD::class.java, "Base de datos Usuario")
            .allowMainThreadQueries()
            .build()

        //Objeto DAO para traer los metodos
        val usuarioDAO = bd.usuarioDAO()

        val sharedPreferences = getSharedPreferences("Usuarios", MODE_PRIVATE)

        val nombreActual = sharedPreferences.getString("Nombre de usuario", "").toString()
        val telefonoActual = sharedPreferences.getString("Numero de telefono", "").toString()

        //Cuando cargue el movil de nuevo, apareceran los datos antiguos
        val user = Usuario(nombreActual, telefonoActual)

        binding.usuario = user

        binding.bGuardar.setOnClickListener {
            val nombre = binding.tietNombre.text.toString()
            val telefono = binding.tietTelefono.text.toString()

            sharedPreferences.edit()
                .putString("Nombre de usuario", nombre)
                .putString("Numero de telefono", telefono)
                .apply()

            Snackbar.make(binding.root, "Datos guardados correctamente", Snackbar.LENGTH_LONG)
                .show()

            usuarioDAO.agrarUsuarioBD(TablaUsuario(0,nombre,telefono))

        }

        binding.bFinalizar.setOnClickListener { finish() }


        binding.bHistorico.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main,FragmentUsuariosAlmacenados())
                .addToBackStack(null)
                .commit()
        }

        binding.bBorrarHistorico.setOnClickListener {
    val nombre = binding.tietNombre.text.toString()
    val telefono = binding.tietTelefono.text.toString()
    usuarioDAO.eliminarUsuarioBD(TablaUsuario(0, nombre, telefono))

    val fragment = supportFragmentManager.findFragmentById(R.id.main)
    if (fragment is FragmentUsuariosAlmacenados) {
        supportFragmentManager.beginTransaction()
            .remove(fragment)
            .commit()
    }
}

    }
}