package com.maraloedev.ejercicio018_sharedpreferences_sqlite_y_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.room.Room
import com.maraloedev.ejercicio018_sharedpreferences_sqlite_y_fragments.databinding.FragmentListaUsuariosBinding

class ListaUsuariosFragment : Fragment() {
    lateinit var binding: FragmentListaUsuariosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaUsuariosBinding.inflate(inflater, container, false)


        val bd = Room.databaseBuilder(requireContext(),Conexion_de_la_Base_de_Datos::class.java, "Usuarios")
            .allowMainThreadQueries()
            .build()
        val usuarios = bd.usuarioDAO()

        val adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_spinner_item, usuarios.listarUsuarios()
        )

        binding.lvDatosUsuario.adapter = adapter
        return binding.root

    }
}