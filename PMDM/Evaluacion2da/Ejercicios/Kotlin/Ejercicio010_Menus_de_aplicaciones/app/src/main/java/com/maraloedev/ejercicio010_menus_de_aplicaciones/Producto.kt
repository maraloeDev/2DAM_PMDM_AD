package com.maraloedev.ejercicio010_menus_de_aplicaciones

data class Producto(val nombre:String,val precio:String) {

    override fun toString(): String {
        return "$nombre"
    }
}