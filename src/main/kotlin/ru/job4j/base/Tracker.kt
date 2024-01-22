package ru.job4j.base

class Tracker {
    private val items = ArrayList<Item>()
    private var ids = 1

    fun add(item: Item): Item {
        item.id = ids++
        items.add(item)
        return item
    }

    fun findAll(): List<Item> = ArrayList(items)

    fun findByName(name: String): List<Item> {
        val rsl = ArrayList<Item>()
        for (item in items) {
            if (name == item.name) {
                rsl.add(item)
            }
        }
        return rsl
    }

    fun findById(id: Int): Item? {
        val index: Int = indexOf(id)
        return if (index != -1) items[index] else null
    }

    fun delete(id: Int): Boolean {
        val index = indexOf(id)
        val rsl = index != -1
        if (rsl) {
            items.removeAt(index)
        }
        return rsl
    }

    fun replace(id: Int, item: Item): Boolean {
        val index = indexOf(id)
        val rsl = index != -1
        if (rsl) {
            item.id = id
            items[index] = item
        }
        return rsl
    }

    private fun indexOf(id: Int): Int {
        var rsl = -1
        for ((index) in items.withIndex()) {
            if (id == items[index].id) {
                rsl = index
                break
            }
        }
        return rsl
    }
}