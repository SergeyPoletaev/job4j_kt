package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset.offset
import org.junit.jupiter.api.Test

class CalcTest {

    @Test
    fun when2plus3then5() {
        assertThat(Calc().sum(2, 3)).isEqualTo(5)
    }

    @Test
    fun when4minus3then1() {
        assertThat(Calc().subtraction(4, 3)).isEqualTo(1)
    }

    @Test
    fun when2multiply3then6() {
        assertThat(Calc().multiply(2, 3)).isEqualTo(6)
    }

    @Test
    fun when2division3() {
        assertThat(Calc().division(2, 3)).isEqualTo(0.66, offset(0.01))
    }
}