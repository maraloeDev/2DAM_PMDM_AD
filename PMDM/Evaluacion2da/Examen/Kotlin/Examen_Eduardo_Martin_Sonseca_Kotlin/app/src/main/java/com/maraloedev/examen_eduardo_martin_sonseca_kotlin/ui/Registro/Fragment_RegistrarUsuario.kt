package com.maraloedev.examen_eduardo_martin_sonseca_kotlin.ui.Registro

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.examen_eduardo_martin_sonseca_kotlin.R
import com.maraloedev.examen_eduardo_martin_sonseca_kotlin.databinding.FragmentRegistrarUsuarioBinding
import com.maraloedev.examen_eduardo_martin_sonseca_kotlin.utils.ConexionBD
import com.maraloedev.examen_eduardo_martin_sonseca_kotlin.utils.TablaUsuario

class Fragment_RegistrarUsuario : Fragment() {

    private lateinit var binding: FragmentRegistrarUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrarUsuarioBinding.inflate(inflater, container, false)

        val bd =
            Room.databaseBuilder(requireContext(), ConexionBD::class.java, "Base dee datos Usuario")
                .allowMainThreadQueries()
                .build()
        val usuarioDAO = bd.usuarioDAO()

        binding.bGuardarUsuario.setOnClickListener {

            val nombreUsuario = binding.tieNombre.text.toString()
            val contraseñaUsuario = binding.tieContra.text.toString()

            val usuario = TablaUsuario(0, nombreUsuario, contraseñaUsuario)

            usuarioDAO.insertarDatosUser(usuario)

            Snackbar.make(binding.root, "Datos guardados correctamente", Snackbar.LENGTH_LONG)
                .show()

            binding.tieNombre.text?.clear()
            binding.tieContra.text?.clear()
        }
        return binding.root
    }
}