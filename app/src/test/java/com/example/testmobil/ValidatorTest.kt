package com.example.testmobil
import android.util.Patterns
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidationUtilsTest {

    private val validationUtils = ValidationUtils()

    @Test
    fun testIsValidEmail_valid() {
        assertTrue(validationUtils.isValidEmail("test@example.com"))
    }

    @Test
    fun testIsValidEmail_invalid() {
        assertFalse(validationUtils.isValidEmail("invalid-email"))
        assertFalse(validationUtils.isValidEmail("test@example"))
    }

    @Test
    fun testIsValidPassword_valid() {
        assertTrue(validationUtils.isValidPassword("password123"))
    }

    @Test
    fun testIsValidPassword_invalid() {
        assertFalse(validationUtils.isValidPassword("pass1"))
    }
}

class ValidationUtils {
    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()
        return emailRegex.matches(email)
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }
}
