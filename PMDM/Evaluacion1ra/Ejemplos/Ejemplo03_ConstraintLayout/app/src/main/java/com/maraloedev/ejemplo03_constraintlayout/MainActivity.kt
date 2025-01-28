package com.maraloedev.ejemplo03_constraintlayout

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.maraloedev.ejemplo03_constraintlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioPrueba = Usuario("Juan", "Perez", "Garcia")
        binding.user = usuarioPrueba

        val listenerTeclado: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Método llamado antes de que el texto cambie
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Método llamado mientras el texto está cambiando
            }

            override fun afterTextChanged(teit_editado: Editable?) {
                // Método llamado después de que el texto ha cambiado
                val cadena: String = teit_editado.toString()
                Log.d("depurando", cadena)

                // Validar los campos de texto
                validarCampos(binding.tilNombre, binding.tietNombre, { texto -> texto.length > 10 })
                validarCampos(binding.tilApellido1, binding.tietApellido1) { texto ->
                    texto.length > 5
                }
                validarCampos(binding.tilApellido2, binding.tietApellido2) { texto ->
                    texto.length > 2
                }
            }
        }

        // Añadir el listener a los campos de texto
        binding.tietNombre.addTextChangedListener(listenerTeclado)
        binding.tietApellido1.addTextChangedListener(listenerTeclado)
        binding.tietApellido2.addTextChangedListener(listenerTeclado)

        // Configurar el botón de recuperar
        binding.bRecuperar.setOnClickListener {
            val nombre = binding.tietNombre.text.toString()
            val apellido1 = binding.tietApellido1.text.toString()
            val apellido2 = binding.tietApellido2.text.toString()
            val usuario = Usuario(nombre, apellido1, apellido2)
            Snackbar.make(binding.main, usuario.toString(), Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun validarCampos(
        layoutCampo: TextInputLayout, campo: TextInputEditText, condicion: (String) -> Boolean
    ) {
        // Validar el campo de texto según la condición
        if (condicion(campo.text.toString())) {
            campo.error = "Error"
            layoutCampo.error = "No puede ser vacío"
        } else {
            campo.error = null
            layoutCampo.error = null
        }
    }
}