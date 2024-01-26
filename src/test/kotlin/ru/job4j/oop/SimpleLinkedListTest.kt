package ru.job4j.oop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Exchanger

internal class SimpleLinkedListTest {

    @Test
    fun whenNotExistElementsThenReturnFalse() {
        val list = SimpleLinkedList<String>()
        val it = list.iterator()
        assertFalse(it.hasNext())
        assertFalse(it.hasNext())
    }

    @Test
    fun whenExistElementsThenReturnTrue() {
        val list = SimpleLinkedList<String>()
        list.add("a")
        val it = list.iterator()
        assertTrue(it.hasNext())
        assertTrue(it.hasNext())
    }

    @Test
    fun whenCorrectIteration() {
        val list = SimpleLinkedList<String>()
        list.add("a")
        list.add("b")
        list.add("c")
        val it = list.iterator()
        assertThat(it.next()).isEqualTo("a")
        assertThat(it.next()).isEqualTo("b")
        assertThat(it.next()).isEqualTo("c")
        assertFalse(it.hasNext())
    }

    @Test
    fun whenNotElementThenEx() {
        val list = SimpleLinkedList<String>()
        assertThrows(NoSuchElementException::class.java) { list.iterator().next() }
    }

    @Test
    fun whenModifyOtherThreadThenEx() {
        val exchanger = Exchanger<Unit>()
        val list = SimpleLinkedList<String>()
        list.add("a")
        val it = list.iterator()
        val task = {
            exchanger.exchange(null)  // 1
            list.add("b")
            exchanger.exchange(null)  // 2
        }
        Thread(task).start()
        assertThrows(ConcurrentModificationException::class.java) {
            exchanger.exchange(null)  // 1
            exchanger.exchange(null)  // 2
            it.next()
        }
    }
}