package com.maraloedev.ejercicio04_componentesbasicos

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejercicio04_componentesbasicos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Inicializo todos los componentes de la GUI y establezco una contraseña
         */
        val contrasena = "1234"
        var etContrasena = binding.tePContrasena
        val tv_Validador = binding.tvValidacion
        val cbMostrarContrasena = binding.cbMostrarContrasena
        val b_Validar = binding.bValidar
        val bMoverBotones = binding.bMoverBotones

        /**
         * Creo una variable listaBotones con una Lista que almacena todos los botones
         */
        var listaBotones = arrayListOf(
            binding.bCero,
            binding.bUno,
            binding.bDos,
            binding.bTres,
            binding.bCuatro,
            binding.bCinco,
            binding.bSeis,
            binding.bSiete,
            binding.bOcho,
            binding.bNueve,
        )

        /**
         * Recorro todos los botones de la lista
         *
         *      cuando le des click, se mostraran en el etContrasena los botones a pulsar
         */
        for (botonesNumeros in listaBotones) {
            botonesNumeros.setOnClickListener {
                etContrasena.setText("${etContrasena.text}${botonesNumeros.text}")
            }
        }

        /**
         * Cuando se active el CheckBox,
         *          cambiará el texto de cbMostrarContrasena a "Ocultar contraseña"
         *          y establecerá el método de transformación de etContrasena a null,
         *          haciendo visible la contraseña.
         *
         *  Si el CheckBox no está activado,
         *          cambiará el texto de cbMostrarContrasena a "Mostrar contraseña"
         *          y establecerá el método de transformación de etContrasena a *
         *          PasswordTransformationMethod.getInstance(),*
         *          haciendo que la contraseña sea oculta.
         */

        cbMostrarContrasena.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                cbMostrarContrasena.text = "Ocultar contraseña"
                etContrasena.transformationMethod = null
            } else {
                cbMostrarContrasena.text = "Mostrar contraseña"
                etContrasena.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

        b_Validar.setOnClickListener {
            if (etContrasena.text.toString().equals(contrasena)) {
                tv_Validador.text = "Contraseña valida"
                etContrasena.setText("")
            } else {
                binding.tvValidacion.text = "Contraseña invalida"
                etContrasena.setText("")
            }

        }

        bMoverBotones.setOnClickListener {
            var moverLista = listaBotones.shuffle()


            for (botonesNumeros in listaBotones) {
                botonesNumeros.setOnClickListener {

                    etContrasena.setText("$")
                }
            }
        }
    }
}