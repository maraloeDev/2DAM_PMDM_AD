package com.maraloedev.ejemplo01_componentesbasicos

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo01_componentesbasicos.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
      //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val nombre = findViewById<EditText>(R.id.etNombreUsuario)

        binding.bRecuperarNombre.setOnClickListener{

            // Obtener el estado civil seleccionado al hacer clic en el botón
            val estadoCivil: String = findViewById<RadioButton>(binding.rgEstadoCivil.checkedRadioButtonId).text.toString()
            val spinnerColor:Spinner = binding.spColores

            // Usar el valor actualizado de estadoCivil
            binding.tvSaludo.text = "Hola ${nombre.text}, estás $estadoCivil y el color favorito es ${spinnerColor.selectedItem}"
        }


        binding.swActivadoDesactivado.setOnCheckedChangeListener{ compoundButton, isChecked ->

            if (isChecked) {
                // Habilitar el botón si el switch está activado
                binding.bRecuperarNombre.isEnabled = true
                binding.swActivadoDesactivado.text ="Activado"
            } else {
                // Deshabilitar el botón si el switch está desactivado
                binding.bRecuperarNombre.isEnabled = false
                binding.swActivadoDesactivado.text ="Desctivado"
            }
        }


        binding.spColores.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                Log.d("depurando", "Seleccionado: ${binding.spColores.selectedItem}")
                //val temp:String=(parent as ArrayAdapter<String>).getItem(position)
                //Log.d("depurando", "Seleccionado: ${temp}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("depurando", "Nada seleccionado")
            }
        }

        //Metemos los datos del desplegable 2 con un adaptador
        var datos_desplegable= arrayOf("Rojo", "Verde", "Azul", "Amarillo")
        binding.spColores2.adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item, datos_desplegable)


    }
}