package com.example.frugl_app
/**
 *SignUp Unit Testing
 */
object SignUpUtil {
    /**
     * Sign Up will fail if User:
     * -userName:
     * -enters an existing username
     * -leaves userName field empty
     * password:
     * -leaves password empty
     * -does not match confirmPassword with password
     * -does not meet password strength requirements @TODO
     */
    fun validatingSignUpInput(
        userName: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        return true
    }
}