package com.maraloedev.ejercicio018_sharedpreferences_sqlite_y_fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.ejercicio018_sharedpreferences_sqlite_y_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bd = Room.databaseBuilder(this,Conexion_de_la_Base_de_Datos::class.java, "Usuarios")
            .allowMainThreadQueries()
            .build()
        val usuarios = bd.usuarioDAO()

        val sharedPreferences = getSharedPreferences("Datos de usuarios", MODE_PRIVATE)

        val nombre = sharedPreferences.getString("Nommbre de usuario", "").toString()
        val numerotelefono = sharedPreferences.getString("Numero de telefono", "").toString()

        val usuario = Usuario(0,nombre, numerotelefono)
        binding.usuario = usuario

        binding.bGuardar.setOnClickListener {

            val nombreActual = binding.tietIntroduceUnNombre.text.toString()
            val telefonoActual = binding.tietIntroduceUnNumeroDeTeleefono.text.toString()
            sharedPreferences.edit()
                .putString("Nombre de usuario ", nombreActual)
                .putString("Numero de telefono ", telefonoActual)
                .apply()

            val usuariosBD = Usuario(0,nombreActual,telefonoActual)

                usuarios.insertarDatos(usuariosBD)

            binding.tietIntroduceUnNombre.text?.clear()
            binding.tietIntroduceUnNumeroDeTeleefono.text?.clear()
            Snackbar.make(binding.root, "Los datos se han guardado correctamente", Snackbar.LENGTH_LONG).show()


        }

        binding.bFinalizar.setOnClickListener { finish() }

        binding.bHistorico.setOnClickListener {


            binding.fragmentContainerView.isVisible = true


             }

    }
}