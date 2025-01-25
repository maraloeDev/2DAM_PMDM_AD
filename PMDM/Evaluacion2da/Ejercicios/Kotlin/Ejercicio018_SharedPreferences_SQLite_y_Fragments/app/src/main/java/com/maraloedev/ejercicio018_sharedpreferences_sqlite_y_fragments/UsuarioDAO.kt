package com.maraloedev.ejercicio018_sharedpreferences_sqlite_y_fragments

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class UsuarioDAO {

    //Selecciono todas las columnas de la tabla para hacer un listado
     @Query("SELECT * FROM usuario")
    abstract fun listarUsuarios():List<Usuario>


    @Insert
    abstract fun insertarDatos(u:Usuario)

    @Delete
    abstract fun eliminarDatos(u:Usuario)
}