package utils

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TablaUsuario::class], version = 1)
abstract class ConexionBD:RoomDatabase() {

    abstract fun usuarioDAO():usuarioDAO


}