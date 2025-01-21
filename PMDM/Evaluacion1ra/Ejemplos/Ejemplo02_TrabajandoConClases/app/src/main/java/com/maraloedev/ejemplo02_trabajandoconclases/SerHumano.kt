package com.maraloedev.ejemplo02_trabajandoconclases

import android.util.Log

open class SerHumano {

    fun saludar() {
        Log.d("Depurando", "Hola")
    }

    fun saludar2(nombre:String):String {
        return "Hola $nombre"
    }
}