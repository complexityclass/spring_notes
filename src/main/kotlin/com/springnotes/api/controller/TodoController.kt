package com.springnotes.api.controller

import com.springnotes.api.data.Todo
import com.springnotes.api.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoController {

    @Autowired
    private lateinit var service: TodoService

    /**
     * Get Todo's
     */
    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTodos(): List<Todo> = service.getTodos()

    /**
     * Insert item
     */
    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun insertTodo(@RequestBody todo: Todo): Todo
            = service.insertTodo(todo)

    /**
     * Delete mapping
     */
    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteTodo(@PathVariable(name = "id") id: String): Boolean
            = service.deleteTodo(id)

    /**
     * Update mapping
     */
    @PostMapping(
            value = ["/update"],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateTodo(@RequestBody todo: Todo): Boolean
            = service.updateTodo(todo)
}