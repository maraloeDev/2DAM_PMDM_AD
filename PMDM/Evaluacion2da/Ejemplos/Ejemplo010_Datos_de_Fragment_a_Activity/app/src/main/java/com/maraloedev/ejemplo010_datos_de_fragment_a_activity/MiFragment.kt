package com.example.ejem10_datosdefragmentaactivity

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.ejemplo010_datos_de_fragment_a_activity.Dato
import com.maraloedev.ejemplo010_datos_de_fragment_a_activity.databinding.FragmentMiBinding


class MiFragment : Fragment() {

    // Vesión 2, implementando Listener
    private lateinit var activityDependiente: EnviandoDatos


    override fun onAttach(context: Context) {
        super.onAttach(context)

        activityDependiente = context as EnviandoDatos

    }

    private lateinit var binding: FragmentMiBinding

    private lateinit var datoViewModel: Dato


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMiBinding.inflate(inflater, container, false)

        binding.bPasarDatoAActivity.setOnClickListener(){
            val dato:String=binding.tietDatoDentroFragment1.text.toString()

            /*
            1ª forma de enviar datos con fragmentResult
            parentFragmentManager.setFragmentResult("datoAEnviar", Bundle().apply {
                putString("dato", dato)
            })*/

            /* 2ª forma con inteface */
            //activityDependiente?.enviarDatos(binding.tietDatoDentroFragment1.text.toString())

            /* 3ª forma con ViewModel */
            datoViewModel= ViewModelProvider(requireActivity())[Dato::class.java]

            //Devolver a través de datoViewModel el valor con un string
            datoViewModel.dato.value=dato


            Snackbar.make(binding.root, "Dato enviado: $dato", Snackbar.LENGTH_LONG).show()
        }

        binding.bPasarDatoAActivity.setOnClickListener {
            val recuperarTxt = binding.tietDatoDentroFragment1.text.toString()
            binding.tvDatoRecibido.text = recuperarTxt

            Snackbar.make(binding.root, "Dato recibido: $recuperarTxt", Snackbar.LENGTH_LONG).show()
        }
        return binding.root
    }
    // 2ª forma de enviar datos con interface
    interface EnviandoDatos {
        fun enviarDatos(datos: String)
    }

}