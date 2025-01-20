package com.maraloedev.ejemplo016_bases_de_datos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Define una entidad de base de datos llamada `Persona` con anotaciones de Room.
// Esta clase representa una tabla en la base de datos con el nombre "persona".
@Entity(tableName = "persona")
data class Persona(
    // Clave primaria que autogenera su valor.
    @PrimaryKey(autoGenerate = true) var id: String = 0,

    // Columna para el nombre de la persona.
    @ColumnInfo(name = "nombre") val nombre: String = "",

    // Columna para la edad de la persona.
    @ColumnInfo(name = "edad") val edad: String = 0,

    // Columna para la dirección de la persona.
    @ColumnInfo(name = "direccion") val direccion: String = ""
)