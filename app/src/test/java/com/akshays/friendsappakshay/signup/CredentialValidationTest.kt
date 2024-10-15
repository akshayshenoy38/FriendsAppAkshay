package com.akshays.friendsappakshay.signup

import com.akshays.friendsappakshay.InstantTaskExectorExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


@ExtendWith(InstantTaskExectorExtension::class)
class CredentialValidationTest {

    // Use InstantTaskExecutorRule to allow LiveData to be tested synchronously


    @ParameterizedTest
    @CsvSource(
        "'email'",
        "'a@b.c'",
        "'ab@b.c'",
        "'ab@bc.c'",
        "''",
        "'     '",
    )
    fun badEmail(email:String) {
        val viewModel = SignUpViewModel()
        viewModel.createAccount(email, ":password", ":about")
        assertEquals(SignupState.BadEmail, viewModel.signupState.value)
    }


    @ParameterizedTest
    @CsvSource(
        "''",
        "'   '",
        "'12345678'",
        "'abcd12345'",
        "'ABcDf123344'",
        "abcgdnk#$",
        "ABCDEF*&"
    )
    fun invalidPassword(password:String) {
        val viewModel = SignUpViewModel()
        viewModel.createAccount("akshayshenoy38@gmail.com", password, ":about")
        assertEquals(SignupState.BadPassword, viewModel.signupState.value)
    }
}