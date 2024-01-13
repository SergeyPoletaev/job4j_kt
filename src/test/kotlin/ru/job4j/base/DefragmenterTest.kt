package ru.job4j.base

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DefragmenterTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun defragment(array: Array<String?>) {
        assertThat(Defragmenter().defragment(array)).isEqualTo(arrayOf("a", "b", null, null))
    }

    companion object {
        @JvmStatic
        fun dataProvider(): Stream<Arguments> =
            Stream.of(
                Arguments.of(arrayOf("a", "b", null, null)),
                Arguments.of(arrayOf("a", null, "b", null)),
                Arguments.of(arrayOf("a", null, null, "b")),
                Arguments.of(arrayOf(null, "a", "b", null)),
                Arguments.of(arrayOf(null, null, "a", "b"))
            )
    }
}