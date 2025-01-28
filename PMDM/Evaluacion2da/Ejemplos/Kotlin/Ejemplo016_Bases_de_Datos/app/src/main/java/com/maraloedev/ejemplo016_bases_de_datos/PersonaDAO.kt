package com.maraloedev.ejemplo016_bases_de_datos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// Define una interfaz DAO (Data Access Object) para la entidad `Persona`.
// Esta interfaz contiene métodos para realizar operaciones CRUD en la base de datos.
@Dao
abstract class PersonaDAO {

    // Consulta para listar todas las personas en la tabla "persona".
    @Query("SELECT * FROM persona")
    abstract fun listar(): List<Persona?>?

    // Consulta para recuperar una persona por su ID.
    @Query("SELECT * FROM persona WHERE id = :id")
    abstract fun recuperarUsuario(id: Int): Persona?

    // Inserta una nueva persona en la tabla "persona".
    @Insert
    abstract fun insertar(p: Persona)

    // Elimina una persona de la tabla "persona".
    @Delete
    abstract fun eliminar(p: Persona)

    // Actualiza una persona en la tabla "persona".
    @Update
    abstract fun actualizar(p: Persona)
}