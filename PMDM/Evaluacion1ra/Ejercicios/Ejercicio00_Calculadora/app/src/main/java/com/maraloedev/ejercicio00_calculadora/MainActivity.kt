package com.maraloedev.ejercicio00_calculadora

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.maraloedev.ejercicio00_calculadora.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        numerosTxt()
    }

    fun numerosTxt() {
        val txtVacio = binding.tvResultado
        txtVacio.text = ""

        val botones = listOf(binding.btnUno, binding.btnDos, binding.btnTres, binding.btnCuatro)

        for (boton in botones) {
            boton.setOnClickListener {
                txtVacio.text = "${txtVacio.text}${boton.text}"
            }
        }

        binding.btnClear.setOnClickListener(View.OnClickListener {
            binding.tvResultado.text=""
        })
    }

}