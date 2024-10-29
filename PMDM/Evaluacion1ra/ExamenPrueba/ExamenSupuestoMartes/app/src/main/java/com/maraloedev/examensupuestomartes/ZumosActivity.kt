package com.maraloedev.examensupuestomartes

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.examensupuestomartes.databinding.ActivityZumosBinding

class ZumosActivity : AppCompatActivity() {
    lateinit var binding: ActivityZumosBinding
    private val listaZumos: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityZumosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperaNombre()

        val spZumos = binding.spZumos
        val b_Servir = binding.bServir
        val launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val updatedList = result.data?.getStringArrayListExtra("ZumosSelected")
                    if (updatedList != null) {
                        listaZumos.clear()
                        listaZumos.addAll(updatedList)
                    }
                }
            }

        b_Servir.setOnClickListener {
            val selectedZumo = spZumos.selectedItem.toString()
            if (selectedZumo == "Seleccione un zumo") {
                Toast.makeText(this, "No has seleccionado ningun zumo", Toast.LENGTH_LONG).show()
            } else {
                listaZumos.add(selectedZumo)
                val intent = Intent(this, ListaZumosActivity::class.java)
                intent.putStringArrayListExtra("ZumosSelected", ArrayList(listaZumos))
                launcher.launch(intent)
            }
        }

        binding.bVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            launcher.launch(intent)
        }
    }

    private fun recuperaNombre() {
        binding.tvBienvenidaCamarero.text =
            "${binding.tvBienvenidaCamarero.text} " + this.intent.getStringExtra("nombreCamarero")
    }
}