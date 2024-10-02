package com.maraloedev.ejemplo02_trabajandoconclases

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo02_trabajandoconclases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Declarar la variable de enlace (binding)
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilitar la visualización de borde a borde
        enableEdgeToEdge()
        // Inflar el diseño utilizando ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Crear una instancia de persona
        val pepe = persona("Pepe", "1234")
        // Actualizar la propiedad contrasena
        pepe.contrasena = "4321"
        // Registrar los detalles de la instancia de persona
        Log.d("Depurando", "Nombre: ${pepe.nombre} \n Contraseña: ${pepe.contrasena}")

        binding.usuario.nombre
        // Inicializar un ArrayList para contener objetos de tipo persona
        val datos: ArrayList<persona> = ArrayList()
        // Establecer el adaptador para el ListView
        binding.lvListaPersonas.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, datos)

        // Establecer un OnClickListener para el botón
        binding.button.setOnClickListener {
            // Crear una nueva instancia de persona utilizando la entrada de los campos TextInputEditText
            val usuario = persona(binding.HintName.text.toString(), binding.HintPassword.text.toString())
            // Registrar los detalles de la nueva instancia de persona
            Log.d("depurando", usuario.toString())
            // Añadir la nueva instancia de persona al adaptador del ListView
            (binding.lvListaPersonas.adapter as ArrayAdapter<persona>).add(usuario)
        }
    }
}