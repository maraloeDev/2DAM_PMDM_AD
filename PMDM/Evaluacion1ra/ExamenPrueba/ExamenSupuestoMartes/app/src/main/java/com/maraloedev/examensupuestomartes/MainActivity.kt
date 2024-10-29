package com.maraloedev.examensupuestomartes

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.examensupuestomartes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        Recupero los componentes
         */

        var isPasswordVisible = false
        val nombreUsuario = binding.etNombre
        val contrasena = binding.etPassword
        val boton_Acceso = binding.bEntrar
        val mostrarContrasena = binding.mostrarContrasena

        mostrarContrasena.setOnClickListener {
            if (isPasswordVisible) {

                // Para poner los valores de la pass en texto
                contrasena.transformationMethod = PasswordTransformationMethod.getInstance()
            } else {

                // Para poner los valores de la pass en *
                contrasena.transformationMethod = null
            }
            isPasswordVisible =!isPasswordVisible
        }

        val launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                // Si el resultado esta bien, entonces recojes el nombre del usuario
                if (result.resultCode == RESULT_OK) {

                //Recupero el nombre del camarero para mostrarlo
                   nombreUsuario.setText(result.data?.getStringExtra("nombreCamarero"))
                }


            }

        boton_Acceso.setOnClickListener {
            if (nombreUsuario.text.isNotEmpty()) {
                val intent = Intent(this, ZumosActivity::class.java)
                intent.putExtra("nombreCamarero", nombreUsuario.text.toString())
                launcher.launch(intent)
            } else {
                Toast.makeText(this, "No has introducido nada",Toast.LENGTH_LONG).show()
            }
        }
    }
}