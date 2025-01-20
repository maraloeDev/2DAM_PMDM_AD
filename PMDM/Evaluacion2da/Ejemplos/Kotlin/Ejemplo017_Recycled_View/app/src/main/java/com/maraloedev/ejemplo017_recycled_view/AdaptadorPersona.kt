package com.maraloedev.ejemplo017_recycled_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maraloedev.ejemplo017_recycled_view.databinding.PersonaBinding

// Clase AdaptadorPersona para el RecyclerView que muestra una lista de objetos Persona
class AdaptadorPersona(private val listaPersonas: MutableList<Persona>) :
    RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder>() {

    // Clase interna PersonaViewHolder que contiene y enlaza las vistas para cada elemento del RecyclerView
    inner class PersonaViewHolder(private val binding: PersonaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Método para enlazar el objeto Persona a las vistas
        fun bind(persona: Persona) {
            binding.persona = persona

            // Establece un listener en el botón de borrar para eliminar el elemento de la lista
            binding.ivBorrar.setOnClickListener {
                val posicion = adapterPosition
                if (posicion != RecyclerView.NO_POSITION) {
                    listaPersonas.removeAt(posicion)
                    notifyItemRemoved(posicion)
                }
            }
        }
    }

    // Infla el layout para cada elemento y crea un ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val binding = PersonaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonaViewHolder(binding)
    }

    // Enlaza los datos al ViewHolder
    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.bind(listaPersonas[position])
    }

    // Devuelve el número total de elementos en la lista
    override fun getItemCount(): Int = listaPersonas.size
}