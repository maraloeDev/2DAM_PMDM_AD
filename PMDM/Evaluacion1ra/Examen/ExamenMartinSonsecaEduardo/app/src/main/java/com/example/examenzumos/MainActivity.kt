package com.example.examenzumos

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenzumos.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioPredeterminado = "palo_valdes"
        val contrasenaPredeterminado = "1234"

        //Creo un usuario
        val usuario = Usuario("palo_valdes", 1234)
        binding.usuario = usuario
        val listaZumos: MutableList<PrecioZumos> = mutableListOf()

        val adapter =
            ArrayAdapter<PrecioZumos>(this, android.R.layout.simple_list_item_1, listaZumos)
        binding.lvZumos.adapter = adapter
        adapter.notifyDataSetChanged()
        val contadorZumos = 0
        val nPlurals =
            binding.tvPrecio.resources.getQuantityText(R.plurals.precioZumos, contadorZumos)

        val launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                if (result.resultCode == RESULT_OK) {
                    val valores = result.data?.getStringExtra("listaZumos")
                }
            }

        binding.bEntrar.setOnClickListener {

            if (binding.tietNombreUsuario.equals(usuarioPredeterminado) || binding.tietNombreUsuario.equals(
                    contrasenaPredeterminado
                )
            ) {
                Snackbar.make(binding.root, "EL USUARIO ESTA MAL", Snackbar.LENGTH_SHORT).show()

            } else {
                binding.tietNombreUsuario.setText("")
                binding.tietContrasena.setText("")
                val intent = Intent(this, EleccionZumosActivity::class.java)
                launcher.launch(intent)
            }
        }
    }
}