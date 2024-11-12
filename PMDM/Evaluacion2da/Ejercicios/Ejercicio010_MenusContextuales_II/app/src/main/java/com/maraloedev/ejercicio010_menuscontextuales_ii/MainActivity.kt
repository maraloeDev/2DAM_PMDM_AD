package com.maraloedev.ejercicio010_menuscontextuales_ii

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejercicio010_menuscontextuales_ii.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.lyColor)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menucolores, menu)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menucolores, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_rojo -> {
                showAlertDialog(Color.RED)
                true
            }

            R.id.item_amarillo -> {
                showAlertDialog(Color.YELLOW)
                true
            }

            R.id.item_verde -> {
                showAlertDialog(Color.GREEN)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showAlertDialog(color: Int) {
        AlertDialog.Builder(this).setTitle("¿Estás seguro?").setPositiveButton("Sí") { _, _ ->
                binding.lyColor.setBackgroundColor(color)
            }.setNegativeButton("No", null).show()
    }
}