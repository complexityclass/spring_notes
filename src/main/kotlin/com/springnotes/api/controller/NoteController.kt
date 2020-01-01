package com.springnotes.api.controller

import com.springnotes.api.data.Note
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {
    /**
     * Get notes
     **/
    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNotes(): List<Note> {
        return listOf(
                Note(id = UUID.randomUUID().toString(),
                     title = "My first note",
                     message = "This is the message for the first note"
                ),
                Note(id = UUID.randomUUID().toString(),
                     title = "My second note",
                     message = "There is a message for the second note"
                )
        )
    }

    /**
     * Insert note. It consumes JSON.
     **/
    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun insertNote(@RequestBody note: Note): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }

    /**
     * Delete note by Id
     * */
    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteNote(@PathVariable(name = "id") id: String): Boolean {
        print("Removing $id")
        return true
    }

    /**
     * Update item
     * */
    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateNote(@RequestBody note: Note): Note {
        note.title += " [updated]"
        note.message += " [updated]"
        return note
    }

}