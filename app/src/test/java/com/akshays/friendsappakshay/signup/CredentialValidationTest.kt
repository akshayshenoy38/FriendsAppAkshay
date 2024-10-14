package com.akshays.friendsappakshay.signup

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CredentialValidationTest {

    // Use InstantTaskExecutorRule to allow LiveData to be tested synchronously
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun badEmail() {
        val viewModel = SignUpViewModel()
        viewModel.createAccount("email", ":password", ":about")
        assertEquals(SignupState.BadEmail, viewModel.signupState.value)
    }
}