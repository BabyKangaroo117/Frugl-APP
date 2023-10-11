package com.example.frugl_app

/**
 * Valid Login:
 *
 *      userName:
 *          - non empty
 *          - valid format (email)
 *
 *         password:
 *              - non empty
 * */
object loginUtil {

    private const val passwordRequirementsPattern = "^(?=.*[a-z])(?=.*\\d)(?=.*[!.,?\$%^&*]).{8,}\$"
    private const val userNameRequirementsPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"

    fun validateLoginInput(
        userName: String,
        password: String
   ): Boolean {
        //username valildation:

        //empty username
        if (userName.isEmpty()){
            return false
        }

        //invalid username (not an email)
        if (!userName.matches(userNameRequirementsPattern.toRegex())){
            return false
        }

        //password validation:

        //empty password
        if(password.isEmpty()){
            return false
        }

        //improper password (doesnt match requirements)
        if(!password.matches(passwordRequirementsPattern.toRegex())){
            return false
        }
        
        return true
    }
}