package com.maraloedev.examenandroid_parte3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maraloedev.examenandroid_parte3.databinding.FragmentUsuariosBinding

class Fragment_Usuarios : Fragment() {
    lateinit var binding: FragmentUsuariosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsuariosBinding.inflate(inflater, container, false)

        // Obtener el número de usuarios registrados
        val numUsuarios = (activity as MainActivity).getNumUsuariosRegistrados()
        binding.tvNumUsuarios.text = numUsuarios.toString()

        return binding.root
    }
}