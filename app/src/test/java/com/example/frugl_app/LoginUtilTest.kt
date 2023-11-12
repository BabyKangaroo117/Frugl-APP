package com.example.frugl_app
import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Valid Login:
 *
 * userName:
 *
 *      - nonempty
 *
 *      - meets format requirements to avoid querying db with invalid username
 *
 * Password:
 *
 *      - nonempty
 *      - meets formate requirements to avoid querying db with nonexistent password
 * */
class LoginUtilTest {

    //valid test password
    private val validTestPassword: String = "Password123."

    //invalid test password
    private val invalidTestPassword: String = "weakahh"

    //valid username
    private val validTestUserName: String = "habibi12@hotmail.com"

    //invalid username
    private val invalidTestUserName: String = "invalid"

    //username testing

    /**Empty Username Test*/
    @Test
    fun `empty userName returns false`(){
        val result = loginUtil.validateLoginInput(
            userName = "",
            password = validTestPassword,
        )

        assertThat(result).isFalse()
    }

    /**Invalid Username Test*/
    @Test
    fun `invalid userName returns false`(){
        val result = loginUtil.validateLoginInput(
            userName = invalidTestUserName,
            password = validTestPassword
        )

        assertThat(result).isFalse()
    }

    //password testing
    /**Empty Password Test*/
    @Test
    fun `empty password returns false`(){
        val result = loginUtil.validateLoginInput(
            userName = validTestUserName,
            password = ""
        )
        assertThat(result).isFalse()
    }

    /**Invalid Password Test*/
    @Test
    fun `invalid password returns false`(){
        val result = loginUtil.validateLoginInput(
            userName = validTestUserName,
            password = invalidTestPassword
        )

        assertThat(result).isFalse()
    }

}