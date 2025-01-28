package com.maraloedev.examenandroid_3ra_parte.utilis

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class TablaUsuarios(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "Nombre") val nombre:String?,
    @ColumnInfo(name = "Contrasena") val contrasena:String?
)