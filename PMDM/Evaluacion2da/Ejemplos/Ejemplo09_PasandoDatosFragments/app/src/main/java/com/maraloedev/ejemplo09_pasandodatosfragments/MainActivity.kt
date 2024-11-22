package com.example.ejem09_pasandodatosfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo09_pasandodatosfragments.R
import com.maraloedev.ejemplo09_pasandodatosfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bPasarDatoFragment.setOnClickListener(){
            val fragment = MiFragment.newInstance(binding.tietDato.text.toString())
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, fragment).commit()
        }



    }
}