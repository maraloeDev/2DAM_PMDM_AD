package utils

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class TablaUsuario (
    @PrimaryKey(autoGenerate = true) val id:Int = 1,
    @ColumnInfo(name = "Nombre de usuario") val nombre:String ="",
    @ColumnInfo(name = "Contraseña de usuario") val contrasena:String=""

    ) {
    override fun toString(): String {
        return "Nombre: $nombre\n contraseña: $contrasena"
    }
}

