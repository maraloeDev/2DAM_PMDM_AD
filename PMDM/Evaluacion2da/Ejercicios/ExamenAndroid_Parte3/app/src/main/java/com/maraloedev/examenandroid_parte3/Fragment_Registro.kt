package com.maraloedev.examenandroid_parte3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.examenandroid_parte3.databinding.FragmentRegistroBinding

class Fragment_Registro : Fragment() {
    lateinit var binding: FragmentRegistroBinding
    private val usuariosRegistrados = ArrayList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistroBinding.inflate(inflater, container, false)

        binding.bGuardar.setOnClickListener {
            val nombreIntroducido = binding.tietIntroduceUsuario.text.toString()
            val contrasenaIntroducida = binding.etpIntroducePassword.text.toString()
            val usuario = Usuario(nombreIntroducido, contrasenaIntroducida)

            usuariosRegistrados.add(usuario)

            Snackbar.make(binding.root, "Datos Almacenados", Snackbar.LENGTH_LONG).show()
        }

        return binding.root
    }

    fun getUsuariosRegistradosSize(): Int {
        return usuariosRegistrados.size
    }
}