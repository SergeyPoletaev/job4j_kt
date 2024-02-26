package ru.job4j.base.collection

fun getDetailedInfo(camp: List<Campaign>): List<String> = camp.map { it.toString() }