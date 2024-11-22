package com.maraloedev.ejemplo012_navigation_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.maraloedev.ejemplo012_navigation_component.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)



        binding.bRetroceder2.setOnClickListener {
            val dato = Bundle().apply { putString("dato", binding.tietDato.text.toString()) }
            findNavController().navigate(R.id.action_fragment1_to_fragment2, dato)
        }
        return binding.root

    }
}