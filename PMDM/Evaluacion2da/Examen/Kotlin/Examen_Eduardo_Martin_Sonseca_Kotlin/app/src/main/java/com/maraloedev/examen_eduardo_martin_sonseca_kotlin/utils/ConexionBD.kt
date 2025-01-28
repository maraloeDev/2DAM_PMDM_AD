package com.maraloedev.examen_eduardo_martin_sonseca_kotlin.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maraloedev.examen_eduardo_martin_sonseca_kotlin.Usuario

@Database(entities = [TablaUsuario::class], version = 1)
abstract class ConexionBD:RoomDatabase() {

    abstract fun usuarioDAO(): usuarioDAO

}