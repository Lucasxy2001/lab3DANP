package com.example.lab3danp.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab3danp.Home.AlumnoItem
import com.example.lab3danp.Home.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val state = viewModel.state

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier.size(30.dp))
        Text(text = "Registro de Alumnos", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        TextField(
            value = state.alumnoName,
            onValueChange = { viewModel.changeName(it) },
            placeholder = { Text(text = "Nombre completo del alumno") }
        )
        TextField(
            value = state.alumnoClassroom,
            onValueChange = { viewModel.changeClassroom(it) },
            placeholder = { Text(text = "Classroom") }
        )
        Button(onClick = { viewModel.createAlumno() }) {
            Text(text = "Agregar Alumno")
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.alumnos) {
                AlumnoItem(alumno = it, modifier = Modifier.fillMaxWidth(), onEdit = {
                    viewModel.editAlumno(it)
                }, onDelete = {
                    viewModel.deleteAlumno(it)
                })
            }
        }

        Spacer(modifier = Modifier.size(30.dp))
        //Redirecciona a la segunda screen
        Button(onClick = { }) {
            Text(text = "Mostrar alumnos por clases")
        }
        /*Button(onClick = { onNavigateToList() }) {
            Text(text = "Mostrar clases")
        }*/
    }
}
