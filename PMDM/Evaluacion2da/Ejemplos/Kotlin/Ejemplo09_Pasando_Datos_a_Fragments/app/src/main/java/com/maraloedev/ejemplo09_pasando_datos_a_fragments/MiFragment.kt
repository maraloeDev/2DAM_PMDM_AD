package com.maraloedev.ejemplo09_pasando_datos_a_fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maraloedev.ejemplo09_pasando_datos_a_fragments.databinding.FragmentMiBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [MiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MiFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    lateinit var binding: FragmentMiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMiBinding.inflate(inflater, container, false)
        binding.tvDatoRecibido.text = param1

        // Configura el listener para el botón
        binding.bPasarDatoFragment1Al2.setOnClickListener {
            // Crea un Bundle con el dato ingresado
            val sacoDatos: Bundle = Bundle()
            sacoDatos.putString("dato", binding.tietDatoDentroFragment1.text.toString())

            // Envía el dato a OtroFragment usando setFragmentResult
            parentFragmentManager.setFragmentResult("datoAEnviar", sacoDatos)
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            MiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}