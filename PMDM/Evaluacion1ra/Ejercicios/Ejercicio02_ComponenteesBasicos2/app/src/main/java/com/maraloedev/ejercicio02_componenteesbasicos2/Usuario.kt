package com.maraloedev.ejercicio02_componenteesbasicos2

class Usuario(var nombre: String, var soltero: Boolean = true, var deportes:List<String> = emptyList(), var edad: Int) {

    constructor() : this(nombre = "", edad = 0)

    constructor(nombre: String, edad: Int, deportes: String) : this(nombre = nombre, soltero = true,deportes= listOf(), edad = edad)
}