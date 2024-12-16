package com.maraloedev.ejemplo013_bottomnavigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maraloedev.ejemplo013_bottomnavigation.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater,container,false)
        return binding.root
    }
}