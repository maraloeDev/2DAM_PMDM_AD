package com.example.ejem09_pasandodatosfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maraloedev.ejemplo09_pasandodatosfragments.databinding.FragmentOtroBinding


class OtroFragment : Fragment() {

    lateinit var binding: FragmentOtroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentOtroBinding.inflate(inflater, container, false)

        parentFragmentManager.setFragmentResultListener("datoAEnviar", this){
            key, bundle ->
            binding.tvDatoRecibidoFragment1.text = bundle.getString("dato")
        }


        return binding.root
    }

}