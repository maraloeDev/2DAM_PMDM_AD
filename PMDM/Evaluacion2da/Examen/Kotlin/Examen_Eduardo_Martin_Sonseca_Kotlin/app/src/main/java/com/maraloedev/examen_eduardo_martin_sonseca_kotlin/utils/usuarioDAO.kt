package com.maraloedev.examen_eduardo_martin_sonseca_kotlin.utils

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface usuarioDAO {

    @Insert
    abstract fun insertarDatosUser(u: TablaUsuario)

    @Query("SELECT * FROM usuario")
    abstract fun listarUsuarios():List<TablaUsuario>
}