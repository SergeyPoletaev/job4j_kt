package ru.job4j.oop

import ru.job4j.base.Tracker

class FindAllAction : Action {

    override fun execute(tracker: Tracker, input: Input): Boolean {
        println(tracker.findAll())
        return true
    }
}