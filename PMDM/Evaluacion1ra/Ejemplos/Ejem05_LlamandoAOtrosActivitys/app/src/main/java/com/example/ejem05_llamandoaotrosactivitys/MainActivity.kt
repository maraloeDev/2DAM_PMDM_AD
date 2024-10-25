package com.example.ejem05_llamandoaotrosactivitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem05_llamandoaotrosactivitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/


        var launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
                if (result.resultCode==RESULT_OK){
                    binding.tvDatoActivity2.text=result.data?.getStringExtra("datoARetornar")
                }
        }

        binding.bIrActivity2.setOnClickListener {
            var miIntent: Intent= Intent(this, Activity2::class.java)
            miIntent.putExtra("dato", binding.tietDato.text.toString())
            //startActivity(miIntent)
            launcher.launch(miIntent)
        }


    }
}