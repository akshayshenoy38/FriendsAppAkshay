package com.akshays.friendsappakshay.signup

import android.util.Log
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.akshays.friendsappakshay.MainActivity
import org.junit.Rule
import org.junit.Test

class SignupTest {
    companion object {
        private const val TAG = "SignupTest"
    }
    @get:Rule
    val signUpTestRule = createAndroidComposeRule<MainActivity>()
    @Test
    fun performSignUp() {
        launchSignUpScreen(signUpTestRule) {
            typeEmail("akshayshenoy38@gmail.com")
            typePassword("password")
            submit()
            Log.d(TAG, "performSignUp: Submmited")
        } verify {
            Log.d(TAG, "performSignUp: verified")
            timelineScreenIsPresent()
        }
    }


}