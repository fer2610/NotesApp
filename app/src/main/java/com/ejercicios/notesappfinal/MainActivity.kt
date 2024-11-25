package com.ejercicios.notesappfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.ejercicios.notesappfinal.navigation.NavManager
import com.ejercicios.notesappfinal.ui.theme.NotesAppFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppFinalTheme {
                // Crear el controlador de navegación
                val navController = rememberNavController()

                // Llamar al sistema de navegación (NavManager)
                NavManager(navController)
            }
        }
    }
}