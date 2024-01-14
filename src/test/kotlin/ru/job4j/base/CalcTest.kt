package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset.offset
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalcTest {

    @Test
    fun when2plus3then5() {
        assertThat(sum(2, 3)).isEqualTo(5)
    }

    @Test
    fun when4minus3then1() {
        assertThat(subtraction(4, 3)).isEqualTo(1)
    }

    @Test
    fun when2multiply3then6() {
        assertThat(multiply(2, 3)).isEqualTo(6)
    }

    @Test
    fun when2division3() {
        assertThat(division(2, 3)).isEqualTo(0.66, offset(0.01))
    }

    @ParameterizedTest
    @MethodSource("providerNumbersCombinationTwoArgs")
    fun whenMaxFromTwoArgs(first: Int, second: Int) {
        assertThat(max(first, second)).isEqualTo(2)
    }

    @ParameterizedTest
    @MethodSource("providerNumbersCombinationThreeArgs")
    fun whenMaxFromThreeArgs(first: Int, second: Int, thrid: Int) {
        assertThat(max(first, second, thrid)).isEqualTo(3)
    }

    companion object {
        @JvmStatic
        fun providerNumbersCombinationTwoArgs(): Stream<Arguments> =
            Stream.of(
                Arguments.of(1, 2),
                Arguments.of(2, 1)
            )

        @JvmStatic
        fun providerNumbersCombinationThreeArgs(): Stream<Arguments> =
            Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(1, 3, 2),
                Arguments.of(3, 2, 1)
            )
    }
}