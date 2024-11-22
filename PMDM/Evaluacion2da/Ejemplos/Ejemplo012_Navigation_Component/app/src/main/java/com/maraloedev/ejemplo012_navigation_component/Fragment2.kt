package com.maraloedev.ejemplo012_navigation_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.maraloedev.ejemplo012_navigation_component.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)

        val dato = arguments?.getString("dato")
        binding.tietDato.setText(dato)

        binding.bAvanzar.setOnClickListener {
            val dato = Bundle().apply { putString("dato", binding.tietDato.text.toString()) }
            findNavController().navigate(R.id.action_fragment1_to_fragment2, dato)
        }

        binding.bRetroceder.setOnClickListener {
            val dato = Bundle().apply { putString("dato", binding.tietDato.text.toString()) }
            findNavController().navigate(R.id.action_fragment1_to_fragment2, dato)
        }
        return binding.root
    }
}