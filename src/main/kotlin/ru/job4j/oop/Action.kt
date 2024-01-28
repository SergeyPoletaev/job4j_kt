package ru.job4j.oop

import ru.job4j.base.Tracker

interface Action {
    fun execute(tracker: Tracker, input: Input): Boolean
}