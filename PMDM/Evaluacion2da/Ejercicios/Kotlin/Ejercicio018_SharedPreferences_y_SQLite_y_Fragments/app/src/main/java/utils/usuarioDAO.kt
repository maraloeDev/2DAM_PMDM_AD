package utils

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface usuarioDAO {

    @Query("SELECT * FROM usuario")
    fun listaUsuarios():List<TablaUsuario>

    @Insert
    fun agrarUsuarioBD(u:TablaUsuario)

    @Delete
    fun eliminarUsuarioBD(u:TablaUsuario)
}