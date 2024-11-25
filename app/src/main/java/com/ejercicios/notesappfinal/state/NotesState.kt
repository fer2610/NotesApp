package com.ejercicios.notesappfinal.state

import com.ejercicios.notesappfinal.model.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false
)