package com.akshays.friendsappakshay.signup

import com.akshays.friendsappakshay.InstantTaskExectorExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantTaskExectorExtension::class)
class CredentialValidationTest {

    // Use InstantTaskExecutorRule to allow LiveData to be tested synchronously


    @Test
    fun badEmail() {
        val viewModel = SignUpViewModel()
        viewModel.createAccount("email", ":password", ":about")
        assertEquals(SignupState.BadEmail, viewModel.signupState.value)
    }
}