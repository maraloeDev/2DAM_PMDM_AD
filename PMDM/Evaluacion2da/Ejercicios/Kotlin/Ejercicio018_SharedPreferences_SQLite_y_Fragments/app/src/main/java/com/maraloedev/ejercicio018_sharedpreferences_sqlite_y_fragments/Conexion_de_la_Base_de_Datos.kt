package com.maraloedev.ejercicio018_sharedpreferences_sqlite_y_fragments

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
abstract class Conexion_de_la_Base_de_Datos:RoomDatabase() {

    abstract fun usuarioDAO(): UsuarioDAO

}