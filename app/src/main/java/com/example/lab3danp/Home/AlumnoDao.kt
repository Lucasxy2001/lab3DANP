package com.example.lab3danp.Home

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface AlumnoDao {
    //Cumple con la operaciones de create y update, ya que sobreescribe un elemento con el mismo id
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlumno(alumno: Alumno)

    @Query("SELECT * FROM alumno")
    fun getAllAlumnos(): Flow<List<Alumno>>

    @Delete
    suspend fun deleteAlumno(alumno: Alumno)

    //@Query("SELECT * FROM alumno WHERE classroom LIKE :clase")
    //fun alumnosClase(clase:String): Flow<List<Alumno>>
}