package com.example.lab3danp.Home

data class HomeState(
    val alumnos: List<Alumno> = emptyList(),
    val alumnoName: String = "",
    val alumnoClassroom: String = "",
    val alumnoId: String? = null
)