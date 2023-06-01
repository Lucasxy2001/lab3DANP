package com.example.lab3danp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.lab3danp.Home.AlumnoDatabase
import com.example.lab3danp.Home.HomeViewModel
import com.example.lab3danp.home.HomeScreen
import com.example.lab3danp.home.Lista
import com.example.lab3danp.ui.theme.Lab3DANPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab3DANPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val database =
                        Room.databaseBuilder(this, AlumnoDatabase::class.java, "alumno_db")
                            .build()
                    val dao = database.dao
                    val viewModel by viewModels<HomeViewModel>(factoryProducer = {
                        object : ViewModelProvider.Factory {
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return HomeViewModel(dao) as T
                            }
                        }
                    })

                    //Implementación de Compose Navigation
                    //val navControler = rememberNavController()
                    /*NavHost(navController = navControler, startDestination = "home") {
                        composable(route = "home") {
                            HomeScreen(
                                viewModel,
                                onNavigateToList = {navControler.navigate("lista")})
                        }
                        composable(route = "lista") {
                            Lista()
                        }
                    }*/
                    HomeScreen(viewModel)
                }
            }
        }
    }
}

