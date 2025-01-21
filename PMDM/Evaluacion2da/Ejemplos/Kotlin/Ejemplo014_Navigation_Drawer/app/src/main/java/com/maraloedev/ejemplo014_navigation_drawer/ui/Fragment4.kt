package com.maraloedev.ejemplo014_navigation_drawer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maraloedev.ejemplo014_navigation_drawer.databinding.Fragment4Binding


class Fragment4 : Fragment() {
    lateinit var binding: Fragment4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment4Binding.inflate(inflater,container,false)

        //Titulo del TextView
        binding.tvTextoPresentacion.text = "Este es el Fragment 4"
        return binding.root
    }

}