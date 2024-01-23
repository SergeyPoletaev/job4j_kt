package ru.job4j.oop

import ru.job4j.base.Item
import ru.job4j.base.Tracker
import java.util.*

object StartUI {
    private val menu = """
        
        ======== Меню =======
        1. Добавить заявку
        2. Показать все заявки
        3. Выйти из программы
        ......................
        
    """.trimIndent()
    private const val exitMsg = "*** Вы вышли из системы. Программа завершена ***"
    private const val successMsg = "*** Item c id %s успешно добавлен в систему ***"
    private const val warnMsg = "*** Вы можете ввести только цифру из предложенных, попробуйте еще раз ***"
    private const val choiceMsg = "Введите номер: "
    private const val taskMsg = "Введите описание задачи: "

    fun init(tracker: Tracker) {
        var flag = true
        val sc = Scanner(System.`in`)
        do {
            println(menu)
            print(choiceMsg)
            when (sc.next()) {
                "1" -> add(tracker, sc)
                "2" -> findAll(tracker)
                "3" -> {
                    flag = false
                    exit()
                }
                else -> println(warnMsg)
            }
        } while (flag)
    }

    private fun add(tracker: Tracker, sc: Scanner) {
        print(taskMsg)
        println(String.format(successMsg, tracker.add(Item(name = sc.next())).id))
    }

    private fun findAll(tracker: Tracker) = println(tracker.findAll())

    private fun exit() = println(exitMsg)
}

fun main() {
    StartUI.init(Tracker())
}