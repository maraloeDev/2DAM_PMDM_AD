package com.maraloedev.ejercicio018_sharedpreferences_y_sqlite_y_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.maraloedev.ejercicio018_sharedpreferences_y_sqlite_y_fragments.databinding.FragmentUsuariosAlmacenadosBinding
import utils.ConexionBD

class FragmentUsuariosAlmacenados : Fragment() {
    private lateinit var binding: FragmentUsuariosAlmacenadosBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsuariosAlmacenadosBinding.inflate(inflater,container,false)

        val bd = Room.databaseBuilder(requireContext(), ConexionBD::class.java, "Base de datos Usuario")
            .allowMainThreadQueries()
            .build()

        //Objeto DAO para traer los metodos
        val usuarioDAO = bd.usuarioDAO()

        binding.tvListadoUsuarios.text = usuarioDAO.listaUsuarios().toString()

        return binding.root

    }

}