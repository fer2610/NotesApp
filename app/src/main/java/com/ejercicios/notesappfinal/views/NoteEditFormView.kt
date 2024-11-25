package com.ejercicios.notesappfinal.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ejercicios.notesappfinal.data.getNoteById
import com.ejercicios.notesappfinal.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteEditFormView(
    navController: NavController,
    noteId: Int,
    onEditNote: (Note) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    LaunchedEffect(noteId) {

        val note = getNoteById(noteId)
        if (note != null) {
            title = note.title
            description = note.description
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Editar Nota") },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF16423C))
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).fillMaxSize()
        ) {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título") }
            )
            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") }
            )
            Button(
                onClick = {
                    val updatedNote = Note(id = noteId, title = title, description = description)
                    onEditNote(updatedNote)
                    navController.popBackStack()
                }
            ) {
                Text("Guardar")
            }
        }
    }
}