package com.springnotes.api.data

import java.util.*

data class Note(
        var id: String? = null,
        var location: String? = null,
        var title: String,
        var message: String) {
}