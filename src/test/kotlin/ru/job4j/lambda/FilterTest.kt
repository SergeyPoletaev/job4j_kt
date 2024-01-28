package ru.job4j.lambda

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FilterTest {

    @Test
    fun whenFilterAccountFindsByCondition() {
        val accounts = listOf(
            Account("Anya", 0),
            Account("Ivan", 1),
            Account("Ivan1", 2),
            Account("Ivan", 0),
        )
        val exp = listOf(
            Account("Ivan", 1),
            Account("Ivan1", 2)
        )
        val res = Filter().filterAccount(accounts, "Ivan", 0)
        assertThat(res).isEqualTo(exp)
    }

    @Test
    fun whenFilterAccountNotFindsByCondition() {
        val accounts = listOf(
            Account("Anya", 1),
            Account("Ivan", 0),
            Account("Ivan1", 0),
        )
        val res = Filter().filterAccount(accounts, "Ivan", 0)
        assertThat(res).isEmpty()
    }
}