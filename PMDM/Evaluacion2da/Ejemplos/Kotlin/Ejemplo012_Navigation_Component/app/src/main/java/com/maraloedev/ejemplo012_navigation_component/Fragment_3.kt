package com.maraloedev.ejemplo012_navigation_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.maraloedev.ejemplo012_navigation_component.databinding.ActivityMainBinding
import com.maraloedev.ejemplo012_navigation_component.databinding.Fragment3Binding

class Fragment_3 : Fragment() {
    lateinit var binding: Fragment3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater,container,false)

        arguments?.getString("dato_recibido")?.let {
            binding.tvDatoRecibido.text = it
        }

        /*val mensaje = requireArguments()?.getString("dato_recibido")
        binding.tvDatoRecibido.text = mensaje*/


        binding.bRetroceder.setOnClickListener(){
            val dato:Bundle = Bundle()
            dato.putString("dato_recibido", binding.tietDato.text.toString())
            findNavController().navigate(R.id.action_fragment_3_to_fragment_2,dato)
        }

        return binding.root
    }
}