package com.maraloedev.ejercicio02_componenteesbasicos2

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
        var tipoDeporte = ""

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

            for (tiposDeporte in deportes) {
                if (tiposDeporte.isChecked) {
                    tipoDeporte += "${tiposDeporte.text}"
                }
            }

            Log.d(
                "DATOS_USUARIO", "El nombre es ${nombre_Usuario.text}" +
                        "\n" +
                        "El estado es $valorRadioButton" +
                        "\n" +
                        "La Comunidad Autonoma elegida es ${binding.spComunidadAutonoma.selectedItem}" +
                        "\n" +
                        "El deporte elegido es ${tipoDeporte}"
            )
        }
    }
}