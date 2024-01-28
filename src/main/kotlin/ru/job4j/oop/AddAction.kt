package ru.job4j.oop

import ru.job4j.base.Item
import ru.job4j.base.Tracker

class AddAction : Action {
    private val successMsg = "*** Item c id %s успешно добавлен в систему ***"
    private val taskMsg = "Введите описание задачи: "


    override fun execute(tracker: Tracker, input: Input): Boolean {
        val taskName = input.ask(taskMsg)
        val item = Item(name = taskName)
        tracker.add(item)
        println(String.format(successMsg, item.id))
        return true
    }
}