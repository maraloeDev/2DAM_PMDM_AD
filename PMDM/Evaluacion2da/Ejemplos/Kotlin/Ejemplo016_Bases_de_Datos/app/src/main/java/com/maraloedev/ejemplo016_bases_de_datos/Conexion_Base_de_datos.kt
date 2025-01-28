package com.maraloedev.ejemplo016_bases_de_datos

import androidx.room.Database
import androidx.room.RoomDatabase

// Define una base de datos con Room, especificando las entidades y la versión de la base de datos.
@Database(entities = [Tabla_Persona::class], version = 1)
abstract class Conexion_Base_de_datos : RoomDatabase() {
    // Método abstracto que devuelve una instancia de PersonaDAO.
    abstract fun personaDao(): PersonaDAO?
}