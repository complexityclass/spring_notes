package com.springnotes.api.service

import com.springnotes.api.data.Todo
import org.springframework.stereotype.Service
import java.util.*

@Service("Todo service")
class TodoService {
    fun getTodos(): List<Todo> = listOf(
            Todo(id = UUID.randomUUID().toString(),
                 title = "First todo title",
                 message = "First todo message",
                 schedule = System.currentTimeMillis()),
            Todo(id = UUID.randomUUID().toString(),
                 title = "Second todo title",
                 message = "Second todo message",
                 schedule = System.currentTimeMillis())
    )

    fun insertTodo(todo: Todo): Todo {
        todo.id = UUID.randomUUID().toString()
        return todo
    }

    fun deleteTodo(id: String): Boolean = false

    fun updateTodo(todo: Todo): Boolean = true
}