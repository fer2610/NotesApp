package com.ejercicios.notesappfinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ejercicios.notesappfinal.data.updateNoteById
import com.ejercicios.notesappfinal.views.*

@Composable
fun NavManager(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") { WelcomeScreen(navController) }
        composable("notes_list") { NoteListView(navController) }
        composable("add_note") { NoteAddFormView(navController) }
        composable("edit_note/{noteId}") { backStackEntry ->
            // Obtener el noteId de los argumentos
            val noteId = backStackEntry.arguments?.getString("noteId")?.toIntOrNull()

            if (noteId != null) {
                NoteEditFormView(
                    navController = navController,
                    noteId = noteId,
                    onEditNote = { updatedNote ->
                        // Aquí implementas la lógica para editar la nota
                        updateNoteById(updatedNote)
                    }
                )
            } else {
                // Opcional: Manejo del caso donde noteId sea nulo
            }
        }
    }
}