package com.maraloedev.ejemplo05_llamandoaotrosactivities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo05_llamandoaotrosactivities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result ->
            if (result.resultCode==RESULT_OK){
                binding.tvDatoActivity2.text=result.data?.getStringExtra("datoARetornar")
            }
        }


        binding.bIrActivity2.setOnClickListener {
            val miIntent = Intent(this, Activity2::class.java)
            miIntent.putExtra("dato", binding.tietDato.text.toString())
            launcher.launch(miIntent)
        }
    }
}