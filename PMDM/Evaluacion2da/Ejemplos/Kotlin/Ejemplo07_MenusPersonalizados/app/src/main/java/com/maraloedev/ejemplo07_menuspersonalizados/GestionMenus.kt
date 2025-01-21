package com.maraloedev.ejemplo07_menuspersonalizados

import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

open class GestionMenus : AppCompatActivity() {

    lateinit var contexto: View

    // Método para crear el menú contextual
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.mi_menu, menu)
    }

    // Método para manejar la selección de ítems del menú contextual
    override fun onContextItemSelected(item: MenuItem): Boolean {

        // Manejar las acciones según el ítem seleccionado
        when(item.itemId) {
            R.id.opcion1 -> Snackbar.make(contexto, "Opción: " + item.title, Snackbar.LENGTH_SHORT)
                .show()
            R.id.opcion2 -> Snackbar.make(contexto, "Opción: " + item.title, Snackbar.LENGTH_SHORT)
                .show()
        }

        // Mostrar un mensaje con la opción seleccionada
        Snackbar.make(contexto, "Opción: "+item.title, Snackbar.LENGTH_SHORT).show()
        return super.onContextItemSelected(item)
    }

    // Método para manejar la selección de ítems del menú de opciones
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return onContextItemSelected(item)
    }

    // Método para crear el menú de opciones
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflar el menú de opciones desde el recurso XML
        menuInflater.inflate(R.menu.mi_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}