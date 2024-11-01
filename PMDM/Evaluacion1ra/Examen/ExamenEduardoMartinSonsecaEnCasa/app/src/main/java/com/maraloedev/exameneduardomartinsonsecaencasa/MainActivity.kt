package com.maraloedev.exameneduardomartinsonsecaencasa

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.exameneduardomartinsonsecaencasa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaZumos: MutableList<precioZumos> = mutableListOf()
        val usuarioPredeterminado = "palo_valdes"
        val contrasenaPredeterminada = 1234

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaZumos)
        binding.lvZumos.adapter = adapter

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val zumosElegidos = result.data?.getParcelableArrayListExtra<precioZumos>("zumosElegidos")
                val precioTotal = result.data?.getIntExtra("precioTotal", 0)

                if (zumosElegidos != null) {
                    listaZumos.clear()
                    listaZumos.addAll(zumosElegidos)
                    adapter.notifyDataSetChanged()
                }
                if (precioTotal != null) {
                    val nPlurals = resources.getQuantityString(R.plurals.precioZumos, precioTotal, precioTotal)
                    binding.tvPrecio.text = nPlurals
                }
            }
        }

        binding.bEntrar.setOnClickListener {
            val nombreUsuario = binding.tietNombreUsuario.text.toString()
            val contrasena = binding.tietContrasena.text.toString()

            if (nombreUsuario != usuarioPredeterminado) {
                binding.tietContrasena.setTextColor(Color.BLACK)
                binding.tietNombreUsuario.setTextColor(Color.RED)
            } else if (contrasena != contrasenaPredeterminada.toString()) {
                binding.tietNombreUsuario.setTextColor(Color.BLACK)
                binding.tietContrasena.setTextColor(Color.RED)
            } else {
                binding.tietNombreUsuario.setTextColor(Color.BLACK)
                binding.tietContrasena.setTextColor(Color.BLACK)
                binding.tietNombreUsuario.setText("")
                binding.tietContrasena.setText("")

                val intent = Intent(this, EleccionZumosActivity::class.java)
                launcher.launch(intent)
            }
        }
    }
}
