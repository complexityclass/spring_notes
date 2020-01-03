package com.springnotes.api.service

import com.springnotes.api.data.Note
import org.springframework.stereotype.Service
import java.util.*

@Service("Note service")
class NoteService {
    fun getNotes(): List<Note> = listOf(
            Note(id = UUID.randomUUID().toString(),
                 title = "My first note",
                 message = "This is a message for the first note"),
            Note(id = UUID.randomUUID().toString(),
                 title = "My second title",
                 message = "This is a message for the second note")
    )

    fun insertNote(note: Note): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }

    fun deleteNote(id: String): Boolean = false

    fun updateNote(note: Note): Boolean = true
}