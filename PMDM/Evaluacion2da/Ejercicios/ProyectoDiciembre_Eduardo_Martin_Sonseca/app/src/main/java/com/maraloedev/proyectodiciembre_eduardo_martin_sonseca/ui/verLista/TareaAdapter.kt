package com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.ui.verLista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.databinding.ItemTareaBinding
import com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.ui.agregarTarea.tarea

class TareaAdapter(
    private val tareas: MutableList<tarea>,
    private val onItemClicked: (tarea) -> Unit,
    private val onDeleteClicked: (tarea) -> Unit
) : RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val binding = ItemTareaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TareaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        holder.bind(tareas[position])
    }


    // Devuelve el número total de ítems en el conjunto de datos mantenido por el adaptador
    override fun getItemCount(): Int = tareas.size

    // Clase ViewHolder que contiene la vista para cada ítem
    inner class TareaViewHolder(private val binding: ItemTareaBinding) : RecyclerView.ViewHolder(binding.root) {
        // Vincula los datos de la tarea a las vistas
        fun bind(tarea: tarea) {
            binding.tvTitulo.text = tarea.titulo // Establece el título
            binding.tvDescripcion.text = tarea.descripcion // Establece la descripción

            // Establece el listener para el clic en el ítem
            binding.root.setOnClickListener {
                onItemClicked(tarea)
            }

            // Establece el listener para el clic en el botón eliminar
            binding.btnEliminar.setOnClickListener {
                onDeleteClicked(tarea)
            }
        }
    }
}