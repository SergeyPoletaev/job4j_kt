package ru.job4j.oop

import java.util.*

class ConsoleInput : Input {
    private val scanner = Scanner(System.`in`)

    override fun ask(question: String): String {
        print(question)
        return scanner.next()
    }
}