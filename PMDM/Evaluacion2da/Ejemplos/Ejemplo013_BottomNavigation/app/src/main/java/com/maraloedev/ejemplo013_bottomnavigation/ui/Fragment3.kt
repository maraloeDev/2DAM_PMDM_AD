package com.maraloedev.ejemplo013_bottomnavigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maraloedev.ejemplo013_bottomnavigation.databinding.Fragment3Binding

class Fragment3 : Fragment() {
    lateinit var binding: Fragment3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater,container,false)
        return binding.root
    }
}