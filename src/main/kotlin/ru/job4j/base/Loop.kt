package ru.job4j.base

fun draw(size: Int) {
    if (size <= 0 || size % 2 == 0) {
        throw IllegalArgumentException(
            """
            Передан параметр size = $size
            Для корректной работы программы size должен быть больше нуля и являться нечетным числом
        """.trimIndent()
        )
    }
    for (row in 0 until size) {
        for (column in 0 until size) {
            if (column == row || column == size - 1 - row) print("*") else print(" ")
        }
        println()
    }
}

fun main() {
    draw(5)
}