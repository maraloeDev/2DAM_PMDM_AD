package com.maraloedev.ejercicio020_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maraloedev.ejercicio020_fragments.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding
    private lateinit var datosActivity: sumaContador
    private var contador: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        datosActivity = activity as sumaContador

        binding.bIncrementar2.setOnClickListener {
            contador++
            binding.tvNumero.text = contador.toString()
            datosActivity.enviarContador(contador)
        }
    }
}

//Creo una interfaz para llamarla desde MainActivity.kt
interface sumaContador {
    fun enviarContador(contador: Int)
}