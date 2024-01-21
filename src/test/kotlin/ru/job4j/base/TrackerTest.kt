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
        assertThat(rsl.getId()).isEqualTo(exp[0].getId())
        assertThat(rsl.getName()).isEqualTo(exp[0].getName())
    }

    @Test
    fun findAll() {
        val tracker = Tracker()
        tracker.add(Item("Name1"))
        tracker.add(Item("Name2"))
        val rsl: List<Item> = tracker.findAll()
        assertThat(rsl.size).isEqualTo(2)
        assertThat(rsl[0].getName()).isEqualTo("Name1")
        assertThat(rsl[1].getName()).isEqualTo("Name2")
    }

    @Test
    fun findByName() {
        val tracker = Tracker()
        tracker.add(Item("Name"))
        tracker.add(Item("Name"))
        val rsl: List<Item> = tracker.findByName("Name")
        assertThat(rsl.size).isEqualTo(2)
    }

    @Test
    fun whenFindByIdThenRslTrue() {
        val tracker = Tracker()
        tracker.add(Item())
        tracker.add(Item())
        val rsl: Item? = tracker.findById(2)
        assertThat(rsl?.getId()).isEqualTo(2)
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
        tracker.add(Item("Name"))
        assertTrue(tracker.replace(1, Item("newName")))
        assertThat(tracker.findById(1)?.getName()).isEqualTo("newName")
    }

    @Test
    fun whenReplaceThenRslFalse() {
        val tracker = Tracker()
        tracker.add(Item("Name"))
        assertFalse(tracker.replace(2, Item("newName")))
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Name")
    }
}