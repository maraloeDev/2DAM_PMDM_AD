package com.maraloedev.examenandroid2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.examenandroid2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val listaUsuario: MutableList<Datos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupListeners()
    }

    private fun setupUI() {
        binding.bAnadir.isEnabled = false
    }

    private fun setupListeners() {
        binding.bAnadir.setOnClickListener { addUser() }
        binding.tbActivarDesactivar.setOnCheckedChangeListener { _, isChecked ->
            toggleButton(
                isChecked
            )
        }
        binding.lvDatosUsuario.setOnItemClickListener { _, _, _, _ -> showUserDetails() }
        binding.bMostrarLista.setOnClickListener { showUserCount() }
    }

    private fun addUser() {
        val et_Nombre = binding.etNombre
        val rb_Sexo = findViewById<RadioButton>(binding.rgSexo.checkedRadioButtonId)

        val newUser = Datos(et_Nombre.text.toString(), rb_Sexo.text.toString())
        listaUsuario.add(newUser)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaUsuario)
        binding.lvDatosUsuario.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun toggleButton(isChecked: Boolean) {
        if (!isChecked) {
            binding.tbActivarDesactivar.text = "OFF"
            binding.bAnadir.isEnabled = false
        } else {
            binding.tbActivarDesactivar.text = "ON"
            binding.bAnadir.isEnabled = true
        }
    }

    private fun showUserDetails() {
        val et_Nombre = binding.etNombre
        val rb_Sexo = findViewById<RadioButton>(binding.rgSexo.checkedRadioButtonId)
        Toast.makeText(
            this, "NOMBRE: ${et_Nombre.text} \nSEXO: ${rb_Sexo.text}", Toast.LENGTH_SHORT
        ).show()
    }

    private fun showUserCount() {
        val numeroUsuarios = listaUsuario.size
        Toast.makeText(
            this, "El numero de personas insertadas son: ${numeroUsuarios}", Toast.LENGTH_SHORT
        ).show()
    }
}