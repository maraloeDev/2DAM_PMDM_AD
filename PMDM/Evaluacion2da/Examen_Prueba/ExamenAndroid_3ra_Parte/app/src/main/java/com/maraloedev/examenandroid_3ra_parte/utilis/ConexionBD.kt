package com.maraloedev.examenandroid_3ra_parte.utilis

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TablaUsuarios::class], version = 1)
abstract class ConexionBD:RoomDatabase() {

    abstract fun usuariosDAO():usuariosDAO
}