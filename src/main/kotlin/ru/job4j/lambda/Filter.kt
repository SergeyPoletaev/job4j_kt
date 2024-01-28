package ru.job4j.lambda

class Filter {

    fun filterAccount(accounts: List<Account>, name: String, balance: Int): List<Account> =
        accounts.filter { it.name.contains(name) && it.balance > balance }
}