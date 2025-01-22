package com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.ui.acercaDe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.R
import com.maraloedev.proyectodiciembre_eduardo_martin_sonseca.databinding.FragmentAcercaDeBinding

class Acerca_de_Fragment : Fragment() {

    lateinit var binding: FragmentAcercaDeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAcercaDeBinding.inflate(inflater, container, false)
        return binding.root

    }
}