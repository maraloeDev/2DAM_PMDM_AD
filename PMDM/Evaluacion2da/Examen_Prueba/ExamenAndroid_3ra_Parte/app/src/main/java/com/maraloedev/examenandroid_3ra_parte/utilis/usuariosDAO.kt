package com.maraloedev.examenandroid_3ra_parte.utilis

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface usuariosDAO {

    @Query("SELECT * FROM usuario")
    abstract fun listarUsuarios():List<TablaUsuarios>

    @Insert
    abstract fun insertarDatos(u: TablaUsuarios)


}