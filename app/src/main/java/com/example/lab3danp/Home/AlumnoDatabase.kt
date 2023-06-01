package com.example.lab3danp.Home

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Alumno::class], version = 1)
abstract class AlumnoDatabase : RoomDatabase() {
    abstract val dao: AlumnoDao
}
