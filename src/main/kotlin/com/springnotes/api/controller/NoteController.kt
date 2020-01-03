package com.springnotes.api.controller

import com.springnotes.api.data.Note
import com.springnotes.api.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @Autowired
    private lateinit var service: NoteService

    /**
     * Get notes
     **/
    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNotes(): List<Note> = service.getNotes()

    /**
     * Insert note. It consumes JSON.
     **/
    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun insertNote(@RequestBody note: Note): Note = service.insertNote(note)

    /**
     * Delete note by Id
     * */
    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteNote(@PathVariable(name = "id") id: String): Boolean = service.deleteNote(id)

    /**
     * Update item
     * */
    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateNote(@RequestBody note: Note): Boolean = service.updateNote(note)
}