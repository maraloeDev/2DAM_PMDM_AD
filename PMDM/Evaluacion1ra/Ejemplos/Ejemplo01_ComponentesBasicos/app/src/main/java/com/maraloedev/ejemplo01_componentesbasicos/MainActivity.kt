package com.maraloedev.ejemplo01_componentesbasicos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
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

        val boton = binding.bRecuperarNombre
        val nombre = findViewById<EditText>(R.id.etNombreUsuario)
        val textoNombre = findViewById<TextView>(R.id.tv_Saludo)
        val estadoCivil:String = findViewById<RadioButton>(binding.rgEstadoCivil.checkedRadioButtonId).text.toString()

        boton.setOnClickListener(View.OnClickListener {
            textoNombre.text ="Hola ${nombre.text}"
        })

        binding.bRecuperarNombre.setOnClickListener(View.OnClickListener {
            binding.tvSaludo.text ="Hola ${nombre.text}, estas $estadoCivil"
        })
    }
}