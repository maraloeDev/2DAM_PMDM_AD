package com.maraloedev.ejemplo02_variables

import androidx.compose.runtime.MutableState

class Persona(nombre : String, edad : Int, sexo:String) : MutableState<Persona> {
    var nombre : String = nombre
    var edad : Int = edad
    var sexo:String = sexo
    override var value: Persona
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun component1(): Persona {
        TODO("Not yet implemented")
    }

    override fun component2(): (Persona) -> Unit {
        TODO("Not yet implemented")
    }


    override fun toString(): String {
        return "La persona se llama $nombre, tiene $edad años y el sexo es $sexo "
    }
}
