package com.ejercicios.notesappfinal.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ejercicios.notesappfinal.data.getNotes
import com.ejercicios.notesappfinal.data.deleteNoteById

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListView(navController: NavController) {
    val notes = getNotes()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Notas") },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF16423C))
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add_note") },
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar Nota"
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding).fillMaxSize()
        ) {
            items(notes) { note ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("edit_note/${note.id}")
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = note.title, style = MaterialTheme.typography.titleMedium)
                        Text(text = note.description, style = MaterialTheme.typography.bodySmall)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { deleteNoteById(note.id) }) {
                            Text("Eliminar")
                        }
                    }
                }
            }
        }
    }
}