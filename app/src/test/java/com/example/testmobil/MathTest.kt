package com.example.testmobil

import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class MathUtils {
    companion object {
        fun sum(a: Int, b: Int): Int {
            return a + b
        }

        fun divide(a: Int, b: Int): Double {
            if (b == 0) {
                throw IllegalArgumentException("Деление на ноль!")
            }
            return a.toDouble() / b
        }
    }
}

class MathUtilsTest {

    @Test
    fun testSum() {
        assertEquals(5, MathUtils.sum(2, 3))
    }

    @Test
    fun testDivide_validInput() {
        assertEquals(2.0, MathUtils.divide(6, 3), 0.001) // delta для сравнения Double
    }

    @Test
    fun testDivide_divideByZero() {
        assertThrows(IllegalArgumentException::class.java) {
            MathUtils.divide(5, 0)
        }
    }

    @Test
    fun testSum_negativeNumbers() {
        assertEquals(-1, MathUtils.sum(-2, 1))
    }

    @Test
    fun testDivide_negativeNumbers() {
        assertEquals(-2.0, MathUtils.divide(-6, 3), 0.001)
    }
}
