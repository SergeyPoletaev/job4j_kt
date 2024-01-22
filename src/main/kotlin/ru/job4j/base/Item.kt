package ru.job4j.base

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Item(
    var id: Int = 0,
    var name: String? = null,
    val created: LocalDateTime = LocalDateTime.now()
) {
    private val formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")

    override fun toString(): String {
        return "Item(id=$id, name=$name, created=${created.format(formatter)})"
    }

}