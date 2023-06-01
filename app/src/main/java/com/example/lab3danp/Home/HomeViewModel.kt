package com.example.lab3danp.Home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.UUID

class HomeViewModel (
    private val dao: AlumnoDao
    ) : ViewModel() {
        var state by mutableStateOf(HomeState())
        private set
        init {
                viewModelScope.launch {
                    dao.getAllAlumnos().collectLatest {
                        state = state.copy(
                            alumnos = it
                        )
                    }
                }
            }

        fun changeName(name: String) {
            state = state.copy(
                alumnoName = name
            )
        }

        fun changeClassroom(classroom: String) {
            state = state.copy(
                alumnoClassroom = classroom
            )
        }

        fun deleteAlumno(alumno: Alumno) {
            viewModelScope.launch {
                dao.deleteAlumno(alumno)
            }
        }

        fun editAlumno(alumno: Alumno) {
            state = state.copy(
                alumnoName = alumno.name,
                alumnoClassroom = alumno.classroom,
                alumnoId = alumno.id
            )
        }

        fun createAlumno() {
            val alumno =
                Alumno(
                    state.alumnoId ?: UUID.randomUUID().toString(),
                    state.alumnoName,
                    state.alumnoClassroom
                )
            viewModelScope.launch {
                dao.insertAlumno(alumno)
            }
            state = state.copy(
                alumnoName = "",
                alumnoClassroom = "",
                alumnoId = null
            )
        }
    }