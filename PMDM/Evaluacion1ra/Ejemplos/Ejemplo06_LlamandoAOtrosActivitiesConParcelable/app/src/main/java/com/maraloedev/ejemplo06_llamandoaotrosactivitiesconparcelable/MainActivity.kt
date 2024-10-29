package com.maraloedev.ejemplo06_llamandoaotrosactivitiesconparcelable

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejemplo06_llamandoaotrosactivitiesconparcelable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
            if (result.resultCode == RESULT_OK) {

        binding.tvDatoPasado.text=result.data?.getStringExtra("datoDevolver")
            }
        }

        binding.bIrAlSegundoActivity.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("dato", binding.tietMandarDato.text.toString())

            launcher.launch(intent)
        }
    }
}