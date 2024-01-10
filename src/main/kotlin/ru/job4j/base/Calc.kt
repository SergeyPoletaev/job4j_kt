package ru.job4j.base

fun sum(first: Int, second: Int): Int {
    return first + second
}

fun subtraction(first: Int, second: Int): Int {
    return first - second
}

fun division(first: Int, second: Int): Double {
    return first / second.toDouble()
}

fun multiply(first: Int, second: Int): Int {
    return first * second
}

fun main(args: Array<String>) {
    val first = 2
    val second = 3

    val plus = sum(first, second)
    val minus = subtraction(first, second)
    val div = division(first, second)
    val multi = multiply(first, second)

    println("$first + $second = $plus")
    println("$first - $second = $minus")
    println("$first / $second = $div")
    println("$first * $second = $multi")
}