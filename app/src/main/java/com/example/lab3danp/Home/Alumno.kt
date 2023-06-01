package com.example.lab3danp.Home

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alumno(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val classroom: String
)

