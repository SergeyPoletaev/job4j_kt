package ru.job4j.oop

import ru.job4j.base.Tracker

class StartUI private constructor() {
    companion object {
        private val menu = """
        
        ======== Меню =======
        1. Добавить заявку
        2. Показать все заявки
        3. Выйти из программы
        ......................
        
    """.trimIndent()
        private const val warnMsg = "*** Вы можете ввести только цифру из предложенных, попробуйте еще раз ***"
        private const val choiceMsg = "Введите номер: "

        fun init(tracker: Tracker, input: Input, actions: Map<String, Action>) {
            var flag = true
            do {
                println(menu)
                when (input.ask(choiceMsg)) {
                    "1" -> actions["add"]?.execute(tracker, input)
                    "2" -> actions["findAll"]?.execute(tracker, input)
                    "3" -> {
                        flag = false
                        actions["exit"]?.execute(tracker, input)
                    }
                    else -> println(warnMsg)
                }
            } while (flag)
        }
    }
}

fun main() {
    val actions = mapOf(
        Pair("add", AddAction()),
        Pair("findAll", FindAllAction()),
        Pair("exit", ExitAction())
    )
    StartUI.init(Tracker(), ConsoleInput(), actions)
}