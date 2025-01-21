package com.maraloedev.ejemplo016_bases_de_datos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Define una entidad de base de datos llamada `Tabla_Persona` con anotaciones de Room.
// Esta clase representa una tabla en la base de datos con el nombre "persona".
@Entity(tableName = "persona")
class Tabla_Persona {

    // Clave primaria que autogenera su valor.
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    // Columna para el nombre de la persona.
    @ColumnInfo(name = "nombre")
    var nombre: String = ""

    // Columna para la edad de la persona.
    @ColumnInfo(name = "edad")
    var edad: Int = 0

    // Columna para la dirección de la persona.
    @ColumnInfo(name = "direccion")
    var direccion: String = ""

    // Constructor para inicializar las propiedades.
    constructor(direccion: String, edad: Int, nombre: String) {
        this.direccion = direccion
        this.edad = edad
        this.nombre = nombre
    }

    // Sobrescribe el método toString para devolver el nombre de la persona.
    override fun toString(): String {
        return nombre
    }
}