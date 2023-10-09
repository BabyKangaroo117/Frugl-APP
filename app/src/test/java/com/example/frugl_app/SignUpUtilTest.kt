package com.example.frugl_app

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SignUpUtilTest{

    //creating a generic valid password for testing cases that reqiure it
    private val validTestPassword: String = "Passoword123"

    //
    private val newUsers = listOf("mark1@gmail.com")

    //generating existing users to test failure of registering with existing username
    private val existingUsers = listOf("Peter@gmail.com","Carl@hotmail.com")

    //VALID TEST CASE
    /**Testing for a successful SignUp submission*/
    @Test
    fun `valid signUp returns true`(){
        val result = SignUpUtil.validatingSignUpInput(
            userName = newUsers[0],
            password = validTestPassword,
            confirmPassword = validTestPassword
        )

        assertThat(result).isTrue()
    }

    /**Testing empty userName*/
    @Test
    fun `empty userName returns false`(){

        val result = SignUpUtil.validatingSignUpInput(
            userName = "",
            password = validTestPassword,
            confirmPassword = validTestPassword
        )
        assertThat(result).isFalse()
    }
    /**Testing user inputing an existing userName*/
    @Test
    fun `existing userName returns false`(){

        val result = SignUpUtil.validatingSignUpInput(
            userName = existingUsers[0],
            password = validTestPassword,
            confirmPassword = validTestPassword
        )

        assertThat(result).isFalse()
    }

    // testing password cases

    /**Testing empty password entry*/
    @Test
    fun `empty password returns false`(){
        val result = SignUpUtil.validatingSignUpInput(
            userName = newUsers[0],
            password = "",
            confirmPassword = ""   //note that since we are testing a single item - we still match comfirm password to password
        )

        assertThat(result).isFalse()
    }

    /**Testing for non-matching confirmation and password*/
    @Test
    fun `confirmPassword doesn't match password returns false`(){
        val result = SignUpUtil.validatingSignUpInput(
            userName = newUsers[0],
            password = validTestPassword,
            confirmPassword = ""
        )

        assertThat(result).isFalse()
    }

    /**testing password not meeting strength requirements*/
    @Test
    fun `password doesn't meet strength requirements returns false`(){
        val result = SignUpUtil.validatingSignUpInput(
            userName = newUsers[0],
            password = "weak",
            confirmPassword = "weak"
        )

        assertThat(result).isFalse()
    }
}