package com.akshays.friendsappakshay.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.akshays.friendsappakshay.RegexCredentialsValidator

class SignUpViewModel(private val credentialsValidator: RegexCredentialsValidator = RegexCredentialsValidator() ) {

    private val _mutableSignUpState = MutableLiveData<SignupState>()
    val signupState: LiveData<SignupState> = _mutableSignUpState

    fun createAccount(email: String, password: String, about: String) {
        when (RegexCredentialsValidator().validate(email, password)) {
            is RegexCredentialsValidator.CredentialValidatorResult.InvalidEmail -> _mutableSignUpState.value =
                SignupState.BadEmail

            is RegexCredentialsValidator.CredentialValidatorResult.InvalidPassword -> _mutableSignUpState.value =
                SignupState.BadPassword

            else ->  SignupState.ValidCredentials
        }




        // If everything is valid
        //_mutableSignUpState.value = SignupState.Success
    }
}


