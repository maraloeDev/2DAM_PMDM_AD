package com.example.ejem03_constraintlayout

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.example.ejem03_constraintlayout.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioPrueba:Usuario= Usuario("Juan", "Perez", "Garcia")
        binding.user=usuarioPrueba



        //setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        val listenerTeclado:TextWatcher=object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(teit_editado: Editable?) {
                val cadena:String=teit_editado.toString()
                Log.d("depurando", cadena)

                validarCampos(binding.tilNombre, binding.tietNombre,{texto -> texto.length>10})
                validarCampos(binding.tilApellido1, binding.tietApellido1)
                {
                        texto -> texto.length>5
                }
                validarCampos(binding.tilApellido2, binding.tietApellido2)
                {
                      texto -> texto.length>2
                }

            }
        }


        binding.tietNombre.addTextChangedListener(listenerTeclado)
        binding.tietApellido1.addTextChangedListener(listenerTeclado)
        binding.tietApellido2.addTextChangedListener(listenerTeclado)




        binding.bRecuperar.setOnClickListener {
            val nombre = binding.tietNombre.text.toString()
            val apellido1 = binding.tietApellido1.text.toString()
            val apellido2 = binding.tietApellido2.text.toString()
            val usuario = Usuario(nombre, apellido1, apellido2)
            Snackbar.make(binding.main, usuario.toString(), Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun validarCampos(layoutCampo: TextInputLayout,campo: TextInputEditText, condicion:(String)->Boolean){


        //if (campo.text.toString().length==0){
        if (condicion(campo.text.toString())){
            campo.error="Error"
            layoutCampo.error="No puede ser vacío"
        } else
        {
            campo.error=null
            layoutCampo.error=null
        }

    }
    }