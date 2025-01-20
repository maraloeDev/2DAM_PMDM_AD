package com.maraloedev.ejemplo012_navigation_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.maraloedev.ejemplo012_navigation_component.databinding.Fragment1Binding

class Fragment_1 : Fragment() {
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater,container,false)


        // Obtener el argumento "dato_recibido" y establecerlo en el TextView si está presente
        arguments?.getString("dato_recibido")?.let {
            binding.tvDatoRecibido.text = it
        }

        // Configurar el listener del botón "Avanzar"
        binding.bAvanzar.setOnClickListener() {
            // Crear un Bundle para pasar datos al siguiente fragmento
            val dato: Bundle = Bundle()
            dato.putString("dato_recibido", binding.tietDato.text.toString())
            // Navegar al fragmento 2 con el Bundle de datos
            findNavController().navigate(R.id.action_fragment_1_to_fragment_2, dato)
        }


        return binding.root
    }
}