package com.springnotes.api.controller

import com.springnotes.api.data.Todo
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoController {
    /**
     * Get Todo's
     */
    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTodos(): List<Todo> {
        return listOf(
                Todo(id = UUID.randomUUID().toString(),
                     title = "First todo title",
                     message = "First todo message",
                     schedule = System.currentTimeMillis()),
                Todo(id = UUID.randomUUID().toString(),
                     title = "Second todo title",
                     message = "Second todo message",
                     schedule = System.currentTimeMillis())
        )
    }

    /**
     * Insert item
     */
    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun insertTodo(@RequestBody todo: Todo): Todo {
        todo.id = UUID.randomUUID().toString()
        return todo
    }

    /**
     * Delete mapping
     */
    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteTodo(@PathVariable(name = "id") id: String): Boolean {
        println("Removing todo $id")
        return true
    }

    /**
     * Update mapping
     */
    @PostMapping(
            value = ["/update"],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateTodo(@RequestBody todo: Todo): Todo {
        todo.title += "+ [updated]"
        todo.message += "+ [updated]"
        todo.schedule = System.currentTimeMillis()
        return todo
    }
}