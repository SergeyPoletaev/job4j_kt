package ru.job4j.base

class Defragmenter {

    fun defragment(array: Array<String?>): Array<String?> {
        val newArray = arrayOfNulls<String>(array.size)
        var index = 0
        for (str in array) {
            if (str != null) {
                newArray[index++] = str
            }
        }
        return newArray
    }
}