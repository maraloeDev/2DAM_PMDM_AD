package com.maraloedev.examen_eduardo_martin_sonseca_kotlin.utils

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Struct

@Entity(tableName = "usuario")
data class TablaUsuario(
    @PrimaryKey(autoGenerate = true) val id:Int = 1,
    @ColumnInfo(name = "nombre") val nombre:String?,
    @ColumnInfo(name = "contrasena") val contrasena:String?
)