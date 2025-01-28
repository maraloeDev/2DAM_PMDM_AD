package com.maraloedev.examen_eduardo_martin_sonseca_kotlin.ui.Listar_Usuarios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.maraloedev.examen_eduardo_martin_sonseca_kotlin.R
import com.maraloedev.examen_eduardo_martin_sonseca_kotlin.databinding.FragmentListarUsuariosBinding
import com.maraloedev.examen_eduardo_martin_sonseca_kotlin.utils.ConexionBD


class Fragment_Listar_Usuarios : Fragment() {
    private lateinit var binding: FragmentListarUsuariosBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListarUsuariosBinding.inflate(inflater,container,false)

        val bd = Room.databaseBuilder(requireContext(), ConexionBD::class.java, "Base dee datos Usuario")
            .allowMainThreadQueries()
            .build()
        val usuarioDAO = bd.usuarioDAO()

        binding.tvNumeroUsuarios.text = usuarioDAO.listarUsuarios().size.toString()
        return binding.root
    }


}