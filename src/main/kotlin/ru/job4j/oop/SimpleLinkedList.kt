package ru.job4j.oop

class SimpleLinkedList<T> : Iterable<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var modCount: Int = 0

    fun add(value: T) {
        if (head == null) {
            head = Node(value)
            tail = head
        } else {
            val newNode = Node(value)
            tail?.next = newNode
            tail = newNode
        }
        modCount++
    }

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }

    private inner class LinkedIt : Iterator<T> {
        private var curr = head
        private var count = modCount

        override fun hasNext(): Boolean {
            if (count != modCount) {
                throw ConcurrentModificationException()
            }
            return curr != null
        }

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val rsl = curr?.value
            curr = curr?.next
            return rsl!!
        }
    }

    private class Node<K>(val value: K, var next: Node<K>? = null)

}