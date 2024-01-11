package ru.job4j.base

class Calc {
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

    fun max(first: Int, second: Int) = if (first > second) first else second

    fun max(first: Int, second: Int, third: Int): Int =
        if (first > second && first > third) first else if (third > second) third else second

}