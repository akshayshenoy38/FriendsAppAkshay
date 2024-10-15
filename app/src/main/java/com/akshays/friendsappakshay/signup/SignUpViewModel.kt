package com.akshays.friendsappakshay.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SignUpViewModel {

    private val _mutableSignUpState = MutableLiveData<SignupState>()
    val signupState: LiveData<SignupState> = _mutableSignUpState

    fun createAccount(email: String, password: String, about: String) {
        when (validate(email, password)) {
            is CredentialValidatorResult.InvalidEmail -> _mutableSignUpState.value =
                SignupState.BadEmail

            is CredentialValidatorResult.InvalidPassword -> _mutableSignUpState.value =
                SignupState.BadPassword

            else -> TODO()
        }




        // If everything is valid
        //_mutableSignUpState.value = SignupState.Success
    }

    private fun validate(
        email: String,
        password: String
    ): CredentialValidatorResult {
        // Email regex pattern
        val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"

        // Password regex pattern: At least one uppercase, one lowercase, one digit, and one special character
        val passwordRegex =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$"

        val result = if (!email.matches(Regex(emailRegex))) {
            CredentialValidatorResult.InvalidEmail
        } else if (!password.matches(Regex(passwordRegex))) {
            CredentialValidatorResult.InvalidPassword
        } else TODO()
        return result
    }

    sealed class CredentialValidatorResult {
        object InvalidEmail: CredentialValidatorResult()
        object InvalidPassword: CredentialValidatorResult()
    }
}


