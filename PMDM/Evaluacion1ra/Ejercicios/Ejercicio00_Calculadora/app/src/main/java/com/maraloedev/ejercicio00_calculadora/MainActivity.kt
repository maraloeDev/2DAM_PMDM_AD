package com.maraloedev.ejercicio00_calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejercicio00_calculadora.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private var listaNumeros: List<Button> = arrayListOf()
private var listaOperaciones: List<Button> = arrayListOf()
private var n1: Int = 0
private var operacion: String = ""
private var n2: Int = 0


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listas()
        recorrido()
        resultado()
    }

    fun listas() {
        listaNumeros = arrayListOf(
            binding.btn0,
            binding.btn1,
            binding.btn2,
            binding.btn3,
            binding.btn4,
            binding.btn5,
            binding.btn6,
            binding.btn7,
            binding.btn8,
            binding.btn9
        )

        listaOperaciones = arrayListOf(
            binding.btnSuma,
            binding.btnResta,
            binding.btnMultiplicacion,
            binding.btnModulo
        )
    }

    fun recorrido() {
        val tvResultado: TextView = binding.tvResultado

        for (numbersList in listaNumeros) {

            numbersList.setOnClickListener {
                tvResultado.text = "${numbersList.text}"

            }
        }

        //OPERACIONES
        //Cuando le de a cualquier boton de operar va a almacenar en n1 lo que hay escrito en el tv
        for (operationList in listaOperaciones) {

            operationList.setOnClickListener {
                n1 = tvResultado.text.toString().toIntOrNull() ?: 0

                tvResultado.text = "${operationList.text}"

                operacion = tvResultado.text.toString()
            }
        }
    }

    fun resultado() {
        val tvResultado: TextView = binding.tvResultado

        binding.btnIgual.setOnClickListener {
            n2 = tvResultado.text.toString().toIntOrNull() ?: 0

            when (operacion) {
                "+" -> tvResultado.text = (n1 + n2).toString()
                "-" -> tvResultado.text = (n1 - n2).toString()
                "*" -> tvResultado.text = (n1 * n2).toString()
                "%" -> if ((n1 % n2) == 0) Toast.makeText(
                    this,
                    "Error, el modulo no puede ser 0",
                    Toast.LENGTH_LONG
                ).show() else tvResultado.text = (n1 % n2).toString()

                else -> tvResultado.text = "No se puede realizar la operación"
            }
        }

    }
}