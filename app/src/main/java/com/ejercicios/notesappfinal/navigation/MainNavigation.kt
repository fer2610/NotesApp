package com.ejercicios.notesappfinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ejercicios.notesappfinal.data.updateNoteById
import com.ejercicios.notesappfinal.views.NoteEditFormView
import com.ejercicios.notesappfinal.views.NoteListView
import com.ejercicios.notesappfinal.views.NoteAddFormView
import com.ejercicios.notesappfinal.views.WelcomeScreen

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable(route = "welcome") {
            WelcomeScreen(navController)
        }
        composable(route = "notes_list") {
            NoteListView(navController)
        }
        composable(route = "add_note") {
            NoteAddFormView(navController)
        }
        composable(route = "edit_note/{noteId}") { backStackEntry ->
            // Extraemos el noteId desde los argumentos de la ruta
            val noteId = backStackEntry.arguments?.getString("noteId")?.toIntOrNull()

            if (noteId != null) {
                // Pasamos la función onEditNote a NoteEditFormView
                NoteEditFormView(
                    navController = navController,
                    noteId = noteId,
                    onEditNote = { updatedNote ->
                        updateNoteById(updatedNote)
                    }
                )
            }
        }
    }
}