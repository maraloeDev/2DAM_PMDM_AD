// FragmentRegistro.kt
package com.maraloedev.examenandroid_3ra_parte.ui.Registro

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.examenandroid_3ra_parte.databinding.FragmentRegistroBinding
import com.maraloedev.examenandroid_3ra_parte.utilis.ConexionBD
import com.maraloedev.examenandroid_3ra_parte.utilis.TablaUsuarios
import com.maraloedev.examenandroid_3ra_parte.utilis.Usuarios

class FragmentRegistro : Fragment() {
    private lateinit var bindingF: FragmentRegistroBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences = requireActivity().getSharedPreferences("Datos Usuarios", Context.MODE_PRIVATE)

        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingF = FragmentRegistroBinding.inflate(inflater, container, false)


        val baseDeDatos = Room.databaseBuilder(
            this.requireContext(),
            ConexionBD::class.java,
            "Base de datos Usuarios"
        )
            .allowMainThreadQueries()
            .build()

        val nombreUsuario = sharedPreferences.getString("Nombre de usuario", "")
        val contrasenaUsuario = sharedPreferences.getString("Contrasena de usuario", "")
        val userDB = Usuarios(0, nombreUsuario.toString(), contrasenaUsuario.toString())

        bindingF.usuario = userDB

        bindingF.bGuardar.setOnClickListener {
            val valorNuevoNombre = bindingF.tietIntroduceUnNombreDeUsuario.text.toString()
            val valorNuevoContrasena = bindingF.tietIntroduceUnaContrasena.text.toString()
            sharedPreferences

            sharedPreferences.edit()
                .putString("Nombre de usuario", valorNuevoNombre)
                .putString("Contrasena de usuario", valorNuevoContrasena)
                .apply()

            Snackbar.make(bindingF.root, "Datos guardados correctamente", Snackbar.LENGTH_LONG)
                .show()

            val CRUDUser = baseDeDatos.usuariosDAO()
            val usuariosBD = TablaUsuarios(0, valorNuevoNombre, valorNuevoContrasena)
            CRUDUser.insertarDatos(usuariosBD)
        }

        return bindingF.root
    }
}