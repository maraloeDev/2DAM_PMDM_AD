package com.maraloedev.examenandroid_parte3

data class Usuario(val nombre:String, val contrasena:String) {

    override fun toString(): String {
        return nombre
    }
}