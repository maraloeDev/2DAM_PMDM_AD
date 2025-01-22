package com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.ui.verLista

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.databinding.FragmentVerListaBinding
import com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.ui.agregarTarea.tarea

class Ver_Lista_Fragment : Fragment() {

    private lateinit var binding: FragmentVerListaBinding
    private lateinit var adapter: TareaAdapter
    private val tareas = mutableListOf<tarea>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener las tareas de SharedPreferences
        tareas.addAll(obtenerTareas())

        // Configurar el RecyclerView
        adapter = TareaAdapter(tareas, this::onItemClicked, this::onDeleteClicked)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    // Método para obtener las tareas almacenadas en SharedPreferences
    private fun obtenerTareas(): List<tarea> {
        val sharedPreferences = requireContext().getSharedPreferences("Tareas", Context.MODE_PRIVATE)
        val titulo = sharedPreferences.getString("titulo", "") ?: ""
        val descripcion = sharedPreferences.getString("descripcion", "") ?: ""
        return if (titulo.isNotEmpty() && descripcion.isNotEmpty()) {
            listOf(tarea(titulo, descripcion))
        } else {
            emptyList()
        }
    }

    // Cuando haces clic en un elemento de la lista, este se elimina
    private fun onItemClicked(tarea: tarea) {
        eliminarTarea(tarea)
    }

    // Método que se llama cuando se hace clic en el botón eliminar
    private fun onDeleteClicked(tarea: tarea) {
        eliminarTarea(tarea)
    }

    // Método para eliminar una tarea
    private fun eliminarTarea(tarea: tarea) {
        tareas.remove(tarea)
        adapter.notifyDataSetChanged()
        // Eliminar la tarea de SharedPreferences
        val sharedPreferences = requireContext().getSharedPreferences("Tareas", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove("titulo")
        editor.remove("descripcion")
        editor.apply()
    }
}