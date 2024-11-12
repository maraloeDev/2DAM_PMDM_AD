package com.maraloedev.ejemplo07_menus

import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity

open class GestionMenus : AppCompatActivity() {

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.mimenu, menu)
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {


        //Snackbar.make(findViewById(R.id.opcion1)), "Opción: "+item.title, Snackbar.LENGTH_SHORT)
        //    .show()

        Log.d("depurando",(item.toString())+" Titulo: "+item.title)

        return super.onContextItemSelected(item)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mimenu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}