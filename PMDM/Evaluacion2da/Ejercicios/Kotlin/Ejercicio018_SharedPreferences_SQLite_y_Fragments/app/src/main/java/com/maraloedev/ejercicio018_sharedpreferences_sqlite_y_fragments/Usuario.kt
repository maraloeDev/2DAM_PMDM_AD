package com.maraloedev.ejercicio018_sharedpreferences_sqlite_y_fragments

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class Usuario(

    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "nombre") val nombre:String,
    @ColumnInfo(name = "numero_Telefono") val numero_Telefono:String

)



