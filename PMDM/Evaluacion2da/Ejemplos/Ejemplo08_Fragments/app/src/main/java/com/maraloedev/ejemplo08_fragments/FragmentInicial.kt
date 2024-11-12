package com.maraloedev.ejemplo08_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maraloedev.ejemplo08_fragments.databinding.FragmentInicialBinding

class FragmentInicial : Fragment() {
    lateinit var binding: FragmentInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInicialBinding.inflate(inflater, container, false)
       // binding.tvFragmentSaludo.text = "Hola Mundo"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bContar.setOnClickListener {
            val contador = binding.tvFragmentSaludo.text.toString().toInt()
            binding.tvFragmentSaludo.text = (contador + 1).toString()
        }
    }
}