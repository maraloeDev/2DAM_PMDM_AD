package com.maraloedev.ejemplo06_intentsyalertas

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.ejemplo06_intentsyalertas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bLanzarNavegador.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(intent)
        }

        binding.bMandarEmail.setOnClickListener() {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo")
            intent.putExtra(Intent.EXTRA_TEXT, "Cuerpo del correo")
            intent.putExtra(
                Intent.EXTRA_EMAIL, arrayOf("victorvergel@verinsis.com",
                "victorvergel@gregoriofer.com"))
            startActivity(intent)
        }

        binding.bLlamarTelefono.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"))
            startActivity(intent)
        }

        binding.bLanzarGoogleMaps.setOnClickListener() {
            val intent = Intent(Intent.ACTION_VIEW,  Uri.parse("geo:41.6525,-4.7245"))
            startActivity(intent)
        }

        // Lanzar WhatsApp
        binding.bWhatsApp.setOnClickListener() {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/34666666666"))
            startActivity(intent)
        }




        binding.bDialogoAlerta.setOnClickListener() {
            AlertDialog.Builder(this)
                .setTitle("Título del diálogo")
                .setMessage("Mensaje del diálogo")
                //.setIcon(android.R.drawable.ic_dialog_alert)
                .setIcon(R.drawable.ic_android_black_24dp)
                .setPositiveButton("Aceptar") { dialog, which ->
                    Snackbar.make(binding.root, "Has pulsado Aceptar", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener() { dialog,
                                                                                   which ->

                    Snackbar.make(binding.root, "Has pulsado Cancelar", Snackbar.LENGTH_SHORT).show()
                })
                .show()
        }

        binding.bDialogoSeleccionMultiple.setOnClickListener() {
            val colores = arrayOf("Rojo", "Verde", "Azul", "Amarillo")
            val seleccionados = booleanArrayOf(true, false, false, false)
            AlertDialog.Builder(this)
                .setTitle("Selecciona colores")
                .setMultiChoiceItems(colores, seleccionados) { dialog, which, isChecked ->
                    seleccionados[which] = isChecked
                }
                .setPositiveButton("Aceptar") { dialog, which ->
                    var coloresSeleccionados = ""
                    for (i in colores.indices) {
                        if (seleccionados[i]) {
                            coloresSeleccionados += colores[i] + ", "
                        }
                    }
                    Snackbar.make(binding.root, "Has seleccionado: $coloresSeleccionados", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        binding.bDiagoloOpcionUnica.setOnClickListener() {
            val colores = arrayOf("Rojo", "Verde", "Azul", "Amarillo")
            val seleccionados = booleanArrayOf(true, false, false, false)
            AlertDialog.Builder(this)
                .setTitle("Selecciona colores")
                .setSingleChoiceItems(colores, 0) { dialog, which ->
                    Snackbar.make(binding.root, "Has seleccionado: ${colores[which]}", Snackbar.LENGTH_SHORT).show()
                }
                .setPositiveButton("Aceptar") { dialog, which ->
                    var coloresSeleccionados = ""
                    for (i in colores.indices) {
                        if (seleccionados[i]) {
                            coloresSeleccionados += colores[i] + ", "
                        }
                    }
                    Snackbar.make(binding.root, "Has seleccionado: $coloresSeleccionados", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }


    }
}