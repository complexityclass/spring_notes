package com.springnotes.api.data

data class Todo(
        var id: String? = null,
        var location: String? = null,
        var title: String,
        var message: String,
        var schedule: Long
)