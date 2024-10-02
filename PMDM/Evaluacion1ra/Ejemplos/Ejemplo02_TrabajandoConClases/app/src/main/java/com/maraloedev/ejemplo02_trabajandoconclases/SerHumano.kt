package com.maraloedev.ejemplo02_trabajandoconclases

import android.util.Log

// Las clases por defecto, son cerradas
//Para heredar de una clase, se pone open a la clase a heredar
open class SerHumano {

    fun saludar() {
        Log.d("Depurando", "Hola")
    }

    fun saludar2(nombre:String):String {
        return "Hola $nombre"
    }
}