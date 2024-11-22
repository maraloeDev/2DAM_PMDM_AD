package com.maraloedev.ejemplo010_datos_de_fragment_a_activity

import androidx.lifecycle.ViewModel

class Contador():ViewModel() {
var contador = 0
    fun incrementar() {
        contador++
    }

    override fun toString(): String {
        return "$contador"
    }


}