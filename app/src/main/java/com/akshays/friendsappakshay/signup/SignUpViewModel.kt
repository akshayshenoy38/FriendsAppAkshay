package com.akshays.friendsappakshay.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SignUpViewModel {

    private val _mutableSignUpState = MutableLiveData<SignupState>()
    val signupState: LiveData<SignupState> = _mutableSignUpState

    fun createAccount(email: String,
                      password: String,
                      about: String) {

        _mutableSignUpState.value = SignupState.BadEmail
    }

}
