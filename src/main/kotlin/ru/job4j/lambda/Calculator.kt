package ru.job4j.lambda

fun decrement(): (Int) -> Int = { num: Int -> num - 1 }

fun squaring(): (Int) -> Int = { num: Int -> num * num }

fun main() {
    val res = { num: Int -> (num - 1) * (num - 1) }
    println(decrement()(5))
    println(squaring()(5))
    println(res(6))
}