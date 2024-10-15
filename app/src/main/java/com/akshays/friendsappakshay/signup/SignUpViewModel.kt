package com.akshays.friendsappakshay.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SignUpViewModel {

    private val _mutableSignUpState = MutableLiveData<SignupState>()
    val signupState: LiveData<SignupState> = _mutableSignUpState

    fun createAccount(email: String, password: String, about: String) {

        // Email regex pattern
        val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"

        // Password regex pattern: At least one uppercase, one lowercase, one digit, and one special character
        val passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$"



        val state = if (!email.matches(Regex(emailRegex))) {
            SignupState.BadEmail
        } else if (!password.matches(Regex(passwordRegex))) {
            SignupState.BadPassword
        } else TODO()

        _mutableSignUpState.value = state

        // If everything is valid
        //_mutableSignUpState.value = SignupState.Success
    }
}
