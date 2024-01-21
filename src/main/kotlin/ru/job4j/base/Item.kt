package ru.job4j.base

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Item {
    private val formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")

    private var id = 0
    private var name: String? = null
    private var created = LocalDateTime.now()

    constructor()

    constructor(name: String) {
        this.name = name
    }

    fun getId(): Int = id

    fun setId(id: Int) {
        this.id = id
    }

    fun getName(): String? = name

    fun setName(name: String) {
        this.name = name
    }

    override fun toString(): String {
        return "Item(id=$id, name=$name, created=${created.format(formatter)})"
    }

}