package com.akshays.friendsappakshay.signup

sealed class SignupState {
    object BadEmail :SignupState()
    object BadPassword :SignupState()
}
