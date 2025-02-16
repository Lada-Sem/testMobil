package com.example.testmobil

import android.content.SharedPreferences
import junit.framework.TestCase.assertFalse
import org.junit.Test
import org.mockito.Mockito.*


class AuthManager(private val sharedPreferences: SharedPreferences) {

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    fun login() {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
    }

    fun logout() {
        sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()
    }
}

class AuthManagerTest {

    @Test
    fun testIsLoggedIn_default() {
        val sharedPreferences = mock(SharedPreferences::class.java)
        val authManager = AuthManager(sharedPreferences)
        `when`(sharedPreferences.getBoolean("isLoggedIn", false)).thenReturn(false)
        assertFalse(authManager.isLoggedIn())
    }

    @Test
    fun testLogin() {
        val sharedPreferences = mock(SharedPreferences::class.java)
        val editor = mock(SharedPreferences.Editor::class.java)
        `when`(sharedPreferences.edit()).thenReturn(editor)
        `when`(editor.putBoolean("isLoggedIn", true)).thenReturn(editor)
        val authManager = AuthManager(sharedPreferences)
        authManager.login()
        verify(editor).apply()
    }
}
