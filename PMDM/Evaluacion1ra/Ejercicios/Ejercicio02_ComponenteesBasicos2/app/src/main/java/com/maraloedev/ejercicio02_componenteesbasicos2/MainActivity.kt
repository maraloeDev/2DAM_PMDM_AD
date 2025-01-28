package com.maraloedev.ejercicio02_componenteesbasicos2

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejercicio02_componenteesbasicos2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * En la variable nombre_Usuario recupero el nombre de usuario
         * Creo una variable tipoDeporte que almacena en una cadena de texto el deporte
         */
        var nombre_Usuario = binding.etNombreUsuario
        var edad_Usuario = binding.etEdad
        var tipoDeporte = ""

        // Evento para la captura del texto en Introduce tu nombre

        nombre_Usuario.setOnKeyListener { view, valorDeTeclaPulsada, keyEvent ->

            Log.d("Depurando", "Has pulsado ${valorDeTeclaPulsada}")
            false

        }

        binding.lvPadre.setOnTouchListener { view, motionEvent ->
            Log.d("Depurando", "Has puelsado el padre")
            false
        }

        binding.lyHijo.setOnTouchListener { view, motionEvent ->
            Log.d("Depurando", "Has puelsado el hijo")
            false
        }

        /**
         * Acción del boton Guardar, cuando pulses el boton,
         *          Recuperas con la variable rgEstado el estado de todos los CheckBox
         *          Recojo con la variable valorRadioButton el valor en formato texto
         *          Creo una lista de deportes, con los depotes que hay en cada CheckBox
         *          Recorro la lista con un bucle foreach
         *          itero sobre la lista deportes
         */

        binding.bGuardar.setOnClickListener {
            val rgEstado = binding.rgEstado
            val valorRadioButton = findViewById<RadioButton>(rgEstado.checkedRadioButtonId).text

            val deportes: ArrayList<CheckBox> =
                arrayListOf(binding.cbTenis, binding.cbFutbol, binding.cbBaloncesto)

            val deportesSeleccionados = deportes.filter { it.isChecked }
            var tipoDeporte = ""

            if (deportesSeleccionados.size == 1) {
                tipoDeporte = "El deporte seleccionado es: ${deportesSeleccionados[0].text}"
            } else if (deportesSeleccionados.size > 1) {
                tipoDeporte = "Los deportes elegidos son: ${deportesSeleccionados.joinToString(", ") { it.text }}"
            }

            val p1 = Usuario(
                nombre = nombre_Usuario.text.toString(),
                edad = edad_Usuario.text.toString().toInt(),
                deportes = deportesSeleccionados.map { it.text.toString() }
            )

            Log.d(
                "DATOS_USUARIO", "El nombre es ${p1.nombre}" +
                        "\n" +
                        "La edad es ${p1.edad}" +
                        "\n" +
                        "El estado es $valorRadioButton" +
                        "\n" +
                        "La Comunidad Autonoma elegida es ${binding.spComunidadAutonoma.selectedItem}" +
                        "\n" +
                        tipoDeporte
            )
        }
    }
}