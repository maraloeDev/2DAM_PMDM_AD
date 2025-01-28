package com.maraloedev.ejercicio01_componentesbasicos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejercicio01_componentesbasicos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultado: TextView = binding.tvResultado
        var listaNumeros: List<Button> = arrayListOf()
        var listaOperaciones: List<Button> = arrayListOf()
        var n1 = 0
        var n2 = 0
        var operador = ""
        
        listaNumeros = arrayListOf(
            binding.btnUno,
            binding.btnDos,
            binding.btnTres,
            binding.btnCuatro,
            binding.btnCinco,
            binding.btnSeis,
            binding.btnSiete,
            binding.btnOcho,
            binding.btnNueve
        )

        /**
         * Recorre la lista entera con los números de listaNumeros.
          */

        for (nBotones in listaNumeros) {
            nBotones.setOnClickListener {
                /**
                 * Cuando se haga clic en el cada boton,
                 *      tomará el número que tiene actualmente el resultado
                 */
                if (resultado.text.contains("Operación no contemplada")) {
                    resultado.text = ""
                }

                resultado.text = "${resultado.text}${nBotones.text}"
            }
        }

        listaOperaciones = arrayListOf(binding.btnMas, binding.btnMenos)

        /**
         * Recorre la lista entera con los botones de listaOperaciones.
         */
        for (nOperaciones in listaOperaciones) {
            nOperaciones.setOnClickListener {
                /**
                 * Cuando se haga clic en el botón de operación
                 *      tomará el número que tiene actualmente el resultado
                 */
                n1 = resultado.text.toString().toIntOrNull() ?: 0
                operador = nOperaciones.text.toString()
                resultado.text = ""

            }
        }
        /**
         * Cuando le doy al boton igual, recupero el numero introducido anteriormente
         */
        binding.btnIgual.setOnClickListener {
            n2 = resultado.text.toString().toIntOrNull() ?: 0

            when (operador) {
                "+" -> resultado.text = (n1 + n2).toString()
                "-" -> resultado.text = (n1 - n2).toString()
                else -> resultado.text = "Operación no contemplada"
            }
        }
        /**
         * Cuando le doy al boton de limpiar, limpio los datos guardados
         */
        binding.btnLimpiar.setOnClickListener {
            operador = ""
            n1 = 0
            n2 = 0
            resultado.text = ""
        }
    }
}