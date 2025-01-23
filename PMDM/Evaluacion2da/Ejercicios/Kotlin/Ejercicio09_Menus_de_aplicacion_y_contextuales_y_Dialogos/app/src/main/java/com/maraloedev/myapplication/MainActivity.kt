package com.maraloedev.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bFinalizar.setOnClickListener {
            DialogoAlerta()
        }
        binding.bFinalizarTambien.setOnClickListener {
            DialogoAlerta()
        }
    }

    private fun DialogoAlerta() {
        AlertDialog.Builder(this)
            .setTitle("Confirmacion")
            .setMessage("¿Conforma que desea salir?")

            .setPositiveButton("Si") { dialog, witch ->
                finish()
            }

            .setPositiveButton("No") { dialog, witch ->
                dialog.dismiss()
            }.show()
    }
}