package com.ejercicios.notesappfinal.data

import com.ejercicios.notesappfinal.model.Note

// Simula una base de datos en memoria
private val notesDatabase = mutableListOf(
    Note(1, "Nota 1", "Descripción de la Nota 1"),
    Note(2, "Nota 2", "Descripción de la Nota 2")
)
private val notes = mutableListOf<Note>()

fun getNoteById(noteId: Int): Note? {
    return notes.find { it.id == noteId }
}

fun updateNoteById(updatedNote: Note) {
    val index = notes.indexOfFirst { it.id == updatedNote.id }
    if (index != -1) {
        notes[index] = updatedNote
    }
}
fun getNotes(): List<Note> {
    return notesDatabase
}


fun deleteNoteById(noteId: Int) {
    notesDatabase.removeAll { it.id == noteId }
}

fun updateNoteInDatabase(note: Note) {
    val index = notesDatabase.indexOfFirst { it.id == note.id }
    if (index != -1) {
        notesDatabase[index] = note
    }
}

fun addNoteToDatabase(note: Note) {
    notesDatabase.add(note)
}