package com.maraloedev.ejemplo06_intents_y_alertas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.ejemplo06_intents_y_alertas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bLanzarNavegador.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
            startActivity(intent)
        }

        binding.bMandarCorreo.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo")
            intent.putExtra(Intent.EXTRA_TEXT, "Cuerpo del correo")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("martinsonsecaeduardo@gmail.com"))
            startActivity(intent)
        }

        binding.bLlamarTelefono.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890"))
            startActivity(intent)
        }

        binding.bLanzarGoogleMaps.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California")
            )
            startActivity(intent)
        }

        binding.bWhatsapp.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://api.whatsapp.com/send?phone=601094161&text=Hola%20Mundo")
            )
            startActivity(intent)
        }

        binding.bAlertas.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Título de la alerta")
                .setTitle("Título de la alerta").setMessage("Mensaje de la alerta")
                .setPositiveButton("Aceptar") { dialog, which ->
                    Snackbar.make(binding.root, "Has pulsado Aceptar", Snackbar.LENGTH_SHORT).show()
                }.setNegativeButton("Cancelar") { dialog, which ->
                    Snackbar.make(binding.root, "Has pulsado Cancelar", Snackbar.LENGTH_SHORT)
                        .show()
                }.setNeutralButton("Neutral") { dialog, which ->
                    Snackbar.make(binding.root, "Has pulsado Neutral", Snackbar.LENGTH_SHORT).show()
                }
                .setIcon(android.R.drawable.star_on).create().show()

        }

        binding.bDialogoSeleccionMultiple.setOnClickListener {
            //Se crea un array con los colores a seleccionar
            val colores = arrayOf("Rojo", "Verde", "Azul", "Amarillo")

            //Se crea un array de booleanos para saber que elementos están seleccionados
            val seleccionados = booleanArrayOf(false, false, false, false)
            AlertDialog.Builder(this).setTitle("Selecciona un color")
                .setMultiChoiceItems(colores, seleccionados) { dialog, which, isChecked ->
                    seleccionados[which] = isChecked


                    //Con el which se puede saber que elemento se ha seleccionado
                }.setPositiveButton("Aceptar") { dialog, which ->
                    var mensaje = "Has seleccionado: "
                    for (i in colores.indices) {
                        if (seleccionados[i]) {
                            mensaje += colores[i] + " "
                        }
                    }
                    Snackbar.make(binding.root, mensaje, Snackbar.LENGTH_SHORT).show()
                }.setNegativeButton("Cancelar") { dialog, which ->
                    Snackbar.make(binding.root, "Has pulsado Cancelar", Snackbar.LENGTH_SHORT)
                        .show()
                }.create().show()
        }

        binding.bDialogoSelecciionSimple.setOnClickListener {

            //Se crea un array con los colores a seleccionar
            val colores = arrayOf("Rojo", "Verde", "Azul", "Amarillo")

            //Se crea un array de booleanos para saber que elementos están seleccionados
            var seleccionado = 0
            AlertDialog.Builder(this).setTitle("Selecciona un color")
                .setSingleChoiceItems(colores, seleccionado) { dialog, which ->
                    seleccionado = which
                    //Con el which se puede saber que elemento se ha seleccionado
                }.setPositiveButton("Aceptar") { dialog, which ->
                    Snackbar.make(binding.root, "Has seleccionado: " + colores[seleccionado], Snackbar.LENGTH_SHORT).show()
                }.setNegativeButton("Cancelar") { dialog, which ->
                    Snackbar.make(binding.root, "Has pulsado Cancelar", Snackbar.LENGTH_SHORT)
                        .show()
                }.create().show()
        }

    }
}