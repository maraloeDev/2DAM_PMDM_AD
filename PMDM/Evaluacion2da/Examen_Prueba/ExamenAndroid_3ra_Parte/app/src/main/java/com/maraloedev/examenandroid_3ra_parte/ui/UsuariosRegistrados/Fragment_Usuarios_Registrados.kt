package com.maraloedev.examenandroid_3ra_parte.ui.UsuariosRegistrados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.maraloedev.examenandroid_3ra_parte.R
import com.maraloedev.examenandroid_3ra_parte.databinding.FragmentUsuariosRegistradosBinding
import com.maraloedev.examenandroid_3ra_parte.utilis.ConexionBD
import com.maraloedev.examenandroid_3ra_parte.utilis.usuariosDAO


class Fragment_Usuarios_Registrados : Fragment() {
    private lateinit var bindingFR: FragmentUsuariosRegistradosBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFR = FragmentUsuariosRegistradosBinding.inflate(inflater, container, false)

        val baseDatos =
            Room.databaseBuilder(requireContext(), ConexionBD::class.java, "Base de datos Usuarios")
                .allowMainThreadQueries().build()

        val userData= baseDatos.usuariosDAO()

        bindingFR.tvTotalRegistros.text = userData.listarUsuarios().size.toString()
        return bindingFR.root
    }
}