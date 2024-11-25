package com.ejercicios.notesappfinal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ejercicios.notesappfinal.model.Note
import com.ejercicios.notesappfinal.room.NoteDatabaseDao
import com.ejercicios.notesappfinal.state.NotesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NoteViewModel(private val dao: NoteDatabaseDao) : ViewModel() {
    private val _state = MutableStateFlow(NotesState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            dao.getAllNotes().collect { notes ->
                _state.value = _state.value.copy(notes = notes)
            }
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch { dao.insert(note) }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch { dao.update(note) }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch { dao.delete(note) }
    }
}