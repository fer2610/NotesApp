package com.ejercicios.notesappfinal.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ejercicios.notesappfinal.data.addNoteToDatabase
import com.ejercicios.notesappfinal.data.getNotes
import com.ejercicios.notesappfinal.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAddFormView(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agregar Nota") },
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
                    val newNote = Note(id = (getNotes().maxOfOrNull { it.id } ?: 0) + 1, title = title, description = description)
                    addNoteToDatabase(newNote)
                    navController.popBackStack()
                }
            ) {
                Text("Guardar")
            }
        }
    }
}