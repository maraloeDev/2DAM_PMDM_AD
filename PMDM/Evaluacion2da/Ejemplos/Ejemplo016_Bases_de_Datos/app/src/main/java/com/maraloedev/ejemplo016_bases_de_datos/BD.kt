package com.maraloedev.ejemplo016_bases_de_datos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Persona::class], version = 1)
public abstract class BD : RoomDatabase() {

    public abstract fun personaDao(): PersonaDao?

}