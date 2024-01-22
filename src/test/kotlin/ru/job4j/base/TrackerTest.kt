package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TrackerTest {

    @Test
    fun add() {
        val tracker = Tracker()
        val rsl: Item = tracker.add(Item())
        val exp: List<Item> = tracker.findAll()
        assertThat(rsl.id).isEqualTo(exp[0].id)
        assertThat(rsl.name).isEqualTo(exp[0].name)
    }

    @Test
    fun findAll() {
        val tracker = Tracker()
        tracker.add(Item(name = "Name1"))
        tracker.add(Item(name = "Name2"))
        val rsl: List<Item> = tracker.findAll()
        assertThat(rsl.size).isEqualTo(2)
        assertThat(rsl[0].name).isEqualTo("Name1")
        assertThat(rsl[1].name).isEqualTo("Name2")
    }

    @Test
    fun findByName() {
        val tracker = Tracker()
        tracker.add(Item(name = "Name"))
        tracker.add(Item(name = "Name"))
        val rsl: List<Item> = tracker.findByName("Name")
        assertThat(rsl.size).isEqualTo(2)
    }

    @Test
    fun whenFindByIdThenRslTrue() {
        val tracker = Tracker()
        tracker.add(Item())
        tracker.add(Item())
        val rsl: Item? = tracker.findById(2)
        assertThat(rsl?.id).isEqualTo(2)
    }

    @Test
    fun whenFindByIdThenRslFalse() {
        val tracker = Tracker()
        tracker.add(Item())
        assertNull(tracker.findById(2))
    }

    @Test
    fun whenDeleteThenRslTrue() {
        val tracker = Tracker()
        tracker.add(Item())
        assertTrue(tracker.delete(1))
        assertThat(tracker.findAll()).isEmpty()
    }

    @Test
    fun whenDeleteThenRslFalse() {
        val tracker = Tracker()
        tracker.add(Item())
        assertFalse(tracker.delete(2))
        assertThat(tracker.findAll()).isNotEmpty
    }

    @Test
    fun whenReplaceThenRslTrue() {
        val tracker = Tracker()
        tracker.add(Item(name = "Name"))
        assertTrue(tracker.replace(1, Item(name = "newName")))
        assertThat(tracker.findById(1)?.name).isEqualTo("newName")
    }

    @Test
    fun whenReplaceThenRslFalse() {
        val tracker = Tracker()
        tracker.add(Item(name = "Name"))
        assertFalse(tracker.replace(2, Item(name = "newName")))
        assertThat(tracker.findAll()[0].name).isEqualTo("Name")
    }
}