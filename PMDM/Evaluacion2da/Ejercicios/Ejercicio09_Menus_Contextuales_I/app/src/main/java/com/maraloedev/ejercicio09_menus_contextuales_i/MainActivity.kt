package com.maraloedev.ejercicio09_menus_contextuales_i

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.DialogTitle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.ejercicio09_menus_contextuales_i.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bFinalizar.setOnClickListener {
            dialegDel()
            binding.bFinalizarTambien.setOnClickListener {
                dialegDel()
            }

            binding.bCambiarIdioma.setOnClickListener {

            }


        }
    }

    fun dialegDel() {
        AlertDialog.Builder(this).setTitle("Confirmación").setMessage("¿Confirma que desea salir?")
            .setPositiveButton("Sí") { dialog, which ->
                System.exit(0)
            }.setNegativeButton("No", null).show()
    }


}
