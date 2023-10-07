package com.example.frugl_app


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SignUpUtilTest{

    //creating a generic valid password for testing cases that reqiure it
    private val validTestPassword: String = "Passoword123"
    //generating existing users to test failure of registering with existing username
    private val existingUsers = listOf("Peter", "Carl")
    @Test
    fun `empty userName returns false`(){
        val result = SignUpUtil.validatingSignUpInput(
            userName = "",
            password = validTestPassword,
            confirmPassword = validTestPassword
        )

        assertThat(result).isFalse()
    }

}