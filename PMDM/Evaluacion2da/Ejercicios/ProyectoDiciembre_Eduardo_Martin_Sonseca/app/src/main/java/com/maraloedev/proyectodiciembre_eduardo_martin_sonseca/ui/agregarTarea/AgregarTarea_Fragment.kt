package com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.ui.agregarTarea

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.databinding.FragmentAgregarTareaBinding

class AgregarTarea_Fragment : Fragment() {

    private lateinit var binding: FragmentAgregarTareaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarTareaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.bAgregarTarea.setOnClickListener {
            // Obtengo el texto de los campos de entrada de título y descripción
            val titulo = binding.etTitulo.text.toString()
            val descripcion = binding.etDescripcion.text.toString()

            // Verifico si ambos campos no están vacíos, y creo un objeto Tarea para almacenar los datos
            if (titulo.isNotEmpty() && descripcion.isNotEmpty()) {
                //
                val tarea = tarea(titulo, descripcion)
                // Guardar el objeto Tarea en SharedPreferences
                saveTarea(tarea)
                // Mostrar un mensaje de éxito
                Toast.makeText(requireContext(), "Tarea guardada correctamente", Toast.LENGTH_SHORT).show()
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Función para guardar el objeto Tarea en SharedPreferences
    private fun saveTarea(tarea: tarea) {
        // Obtener el objeto SharedPreferences
        val sharedPreferences = requireContext().getSharedPreferences("Tareas", Context.MODE_PRIVATE)
        // Obtener el editor de SharedPreferences
        val editor = sharedPreferences.edit()
        // Poner el título y la descripción en SharedPreferences
        editor.putString("titulo", tarea.titulo)
        editor.putString("descripcion", tarea.descripcion)
        // Aplicar los cambios
        editor.apply()
    }
}