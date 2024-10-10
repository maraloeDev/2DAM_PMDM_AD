package com.maraloedev.ejercicio06_cafetera

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.ejercicio06_cafetera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Recogo todos los componentes de la GUI en variables
         */
        var spinner_Cafes = binding.spTiposCafe
        var textView_Recaudado = binding.tvRecaudado
        var textView_Total = binding.tvTotal
        var checkBox_Azucar = binding.cbAzucar
        var switch_SN = binding.swSiNo
        var button_ServirCafe = binding.btnServir
        var precioCafe = 1.0

        /**
         * Añado a la lista de cafe el cafe seleccionado
         * Establezco al principio de la app que el boton esde deshabilitado
         */

        button_ServirCafe.isEnabled = false

        /**
         * En el evento setOnCheckedChangeListener, establezco que:
         *              Si esta activado, cambias el texto a ON, y el boton se habilita
         *              No esta activado, cambias el texto a OFF y el boton se deshabilita
         */
        switch_SN.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                switch_SN.text = "ON"
                button_ServirCafe.isEnabled = true
                precioCafe = 1.0
                textView_Recaudado.text = "Lleva recaudado: $precioCafe €"

            } else {
                switch_SN.text = "OFF"
                button_ServirCafe.isEnabled = false
                precioCafe = 0.0
                textView_Recaudado.text = "Lleva recaudado: $precioCafe €"
            }
        }

        /**
         * En el evento setOnClickListener, establezco que:
         *              Si esta activado, entonces, muestra el total y suma 0.5 a precioCafe
         *              No esta activado, entonces, muestra el total y resta 0.5 a precioCafe
         */
        button_ServirCafe.setOnClickListener {
            if (checkBox_Azucar.isChecked) {
                textView_Total.text = "Servido ${spinner_Cafes.selectedItem}, con extra de azúzar"
                precioCafe += 0.5
            } else {
                textView_Total.text = "Servido ${spinner_Cafes.selectedItem}, sin extra de azúzar"
                precioCafe -= 0.5
            }
            if (precioCafe < 0) {
                precioCafe = 0.0
                textView_Recaudado.text = "Lleva recaudado: $precioCafe €"
            } else {
                textView_Recaudado.text = "Lleva recaudado: $precioCafe €"
            }
        }
    }
}