package com.maraloedev.ejemplo00_holamundo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Escribir por consola
        Log.d("Depurando", "Saludo en consola")

        //Val el un valor que NO se puede modificar
        val numero: Int = 10
        //numero = numero *10

        //Var es una variable que se puede modificar
        var numero1: Int = 11
        numero1 = 10
        Log.d("Depurando en Kotlin", "El numero es $numero")
        Log.d("Depurando en Kotlin", getString(R.string.Saludo_log))

        //Int, Long. Float, Double, Char, String, Boolean
        var altura: Double = 1.75
        var datoFloat: Float = 3.49f
        var datoLong: Long = 1L

        //Estructuras de control
        if (numero == 10 && numero1 == 20) {

            Log.d("Depurando", "El numero es mayor que 10")
            Log.d("Depurando", "El numero es mayor que 20")
        } else {
            Log.d("Nada", "Nada")
        }

        var edad: Int = 19

        if (edad >= 18) {

            Log.d("Depurando If", "Es mayor de edad")
        } else {
            Log.d("Depurando If", "Es menor de edad")
        }

        // El ? se usa para saber que es un String
        var posibleNulo: String? = null

        if (posibleNulo.isNullOrBlank()) {
            Log.d("Depurando", "La variable esta vacia")
        } else {
            Log.d("Depurando", "La variable tiene contenido")
        }

        //When
        when (edad) {
            18 -> Log.d("Depurando", "Tiene 18 años")
            in 19..25 -> Log.d("Depurando", "Tiene entre 19 y 25 años")
            1, 2, 3, 4 -> Log.d("Depurando", "Tiene entre 1 y 4 años")
            else -> Log.d("Depurando", "Tiene otra edad")
        }

        var fecha: String = "2021-09-01"

        when (fecha.substring(0, 3)) {
            "2021" -> Log.d("Depurando", "Es del 2021")
            "2022" -> Log.d("Depurando", "Es del 2022")
            else -> Log.d("Depurando", "Es de otro año")
        }

        //Bucles

        var arrayNumeros = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        var arrayNumeros2 = arrayOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        var arrayNumeros3 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        var arrayCaracteres = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')

        //Bucle for
        for (numero in arrayNumeros) {
            Log.d("BFor", "El numero es $numero")
        }

        for (i in 0 until arrayNumeros.size) {
            Log.d("BFor", "El numero es ${arrayNumeros.get(i)}")
        }

        //Do While

        var i: Int = 0

        do {
            Log.d("BDW", "El numero es ${arrayNumeros.get(i)}")
            i++

        } while (i < arrayNumeros.size)

        //Bucle While

        while (i < arrayNumeros.size) {
            Log.d("BDW", "El numero es ${arrayNumeros.get(i)}")
            i++
        }

        //ArrayBidimensional (Se recorren 2 veces con un bucle for)

        var matriz:Array<Array<Int>> = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6),
            arrayOf(7, 8, 9),
        )

        for (index in matriz) {
            for (elemento in index){
                Log.d("Matriz", "Los numeros son $elemento")
            }

        }
    }
}