package com.maraloedev.ejemplo016_bases_de_datos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
abstract class PersonaDao {
    @Query("SELECT * FROM persona")
    abstract fun listar(): List<Persona>?

    @Query("SELECT * FROM persona where id = :id")
    abstract fun recuperarUsuario(id: Int): Persona?

    @Insert
    abstract fun insertar(p: Persona)

    @Delete
    abstract fun eliminar(p: Persona)

    @Update
    abstract fun actualizar(p: Persona)
}
