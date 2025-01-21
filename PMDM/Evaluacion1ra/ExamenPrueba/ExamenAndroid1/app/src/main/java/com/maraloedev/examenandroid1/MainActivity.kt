package com.maraloedev.examenandroid1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.examenandroid1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val listaAlumnos: MutableList<Alumno> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etNombre = binding.etNombre
        val spCalificaciones = binding.spCalificaciones
        val bGuardar = binding.bGuardar
        val tvSuspensos = binding.tvSuspensos
        val lvNotaUsuario = binding.lvNotaUsuario


        val alumno = Alumno("Eduardo", "Aprobado")
        binding.alumno = alumno

        var nSuspensos = 0

        bGuardar.setOnClickListener {
            val nombreUser = etNombre.text.toString()
            val calificacion = spCalificaciones.selectedItem.toString()
            val adapter =
                ArrayAdapter<Alumno>(this, android.R.layout.simple_spinner_item, listaAlumnos)
            lvNotaUsuario.adapter = adapter
            val newUser = Alumno(nombreUser, calificacion)
            listaAlumnos.add(newUser)
            adapter.notifyDataSetChanged()

            if (calificacion == "Suspenso") {
                nSuspensos++
                val usuarioSuspendido =
                    resources.getQuantityString(R.plurals.alumnosSuspensos, nSuspensos, nSuspensos)
                tvSuspensos.text = usuarioSuspendido
            }
        }

        lvNotaUsuario.setOnItemClickListener { adapterView, view, i, l ->
            val nombreUser = etNombre.text.toString()
            val calificacion = spCalificaciones.selectedItem.toString()
            Toast.makeText(
                this,
                " NOMBRE: $nombreUser \n CALIFICACIÓN: $calificacion",
                Toast.LENGTH_SHORT
            ).show()
        }


    }
}