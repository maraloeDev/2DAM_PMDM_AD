package com.maraloedev.ejemplo02_trabajandoconclases

import android.util.Log

class Persona (var nombre:String) : SerHumano(), Atleta {

        var contrasena =""
        var edad:Int? = null

        constructor() : this("","")

        constructor(nombre: String, contrasena:String):this(nombre) {
            this.contrasena = contrasena

        }

        constructor(nombre: String, contrasena:String, edad: Int?):this(nombre, contrasena) {
            this.edad = edad
        }

        override fun toString(): String {
            return "persona(Nombre='$nombre',\n Contrasena='$contrasena', \n Edad=$edad)"
        }

        override fun correr() {
            Log.d("Depurando", "Corriendo")
        }
}