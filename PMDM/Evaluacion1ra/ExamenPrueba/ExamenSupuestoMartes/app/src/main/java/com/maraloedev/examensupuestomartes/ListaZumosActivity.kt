package com.maraloedev.examensupuestomartes

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.examensupuestomartes.databinding.ActivityListaZumosBinding

class ListaZumosActivity : AppCompatActivity() {
    lateinit var binding: ActivityListaZumosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListaZumosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaZumos: MutableList<String> = intent.getStringArrayListExtra("ZumosSelected")?.toMutableList() ?: mutableListOf()
        val zumosPedidos = binding.lvZumos

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaZumos)
        zumosPedidos.adapter = adapter
        adapter.notifyDataSetChanged()

        binding.bVolver1.setOnClickListener {
            val intent = Intent()
            intent.putStringArrayListExtra("ZumosSelected", ArrayList(listaZumos))
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}