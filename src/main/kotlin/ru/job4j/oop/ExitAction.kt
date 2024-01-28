package ru.job4j.oop

import ru.job4j.base.Tracker

class ExitAction : Action {
    private val exitMsg = "*** Вы вышли из системы. Программа завершена ***"

    override fun execute(tracker: Tracker, input: Input): Boolean {
        println(exitMsg)
        return true
    }
}