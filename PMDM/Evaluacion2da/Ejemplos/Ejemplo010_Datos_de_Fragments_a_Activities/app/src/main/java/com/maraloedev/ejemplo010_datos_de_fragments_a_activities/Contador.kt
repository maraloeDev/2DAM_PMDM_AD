package com.maraloedev.ejemplo010_datos_de_fragments_a_activities

import androidx.lifecycle.ViewModel

class Contador : ViewModel(){
    var contador=0
    fun incrementar(){
        contador++
    }

}