package com.akshays.friendsappakshay

class RegexCredentialsValidator {


    fun validate(
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
        } else {
            CredentialValidatorResult.ValidCredentials
        }
        return result
    }

    sealed class CredentialValidatorResult {
        object InvalidEmail : CredentialValidatorResult()
        object InvalidPassword : CredentialValidatorResult()
        object ValidCredentials : CredentialValidatorResult()

    }

}