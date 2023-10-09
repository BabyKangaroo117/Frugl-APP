package com.example.frugl_app

/**
 *SignUp Unit Testing
 */

/**
 * Singleton Object to perform validation new signups
 *
 *
 * Sign Up will fail if User:
 *
 * -userName:
 *
 *      -enters an existing username
 *
 *      -leaves userName field empty
 *
 * password:
 *
 *      -leaves password empty
 *
 *      -does not match confirmPassword with password
 *
 * @TODO does not meet password strength requirements
 * @return boolean
 */
object SignUpUtil {
    //password validation regex
    /**
     * password regex:
     *
     *      - atleast 1 lowercase letter
     *
     *      - atleast 1 uppercase letter
     *
     *      - atleast 1 digit
     *
     *      - atleast 1 special character from [!.,?$%^&*]
     *
     *      - password must be 8 characters or longer
     */
    private const val passwordRequirementsPattern = "^(?=.*[a-z])(?=.*\\d)(?=.*[!.,?\$%^&*]).{8,}\$"

    fun validatingSignUpInput(
        userName: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        //USERNAME VALIDATION

        //case for empty user name being entered
        if (userName.isEmpty()){
            return false
        }

        //@TODO case for existing username being entered
        //...

        //PASSWORD VALIDATION

        //case for empty password being entered
        if(password.isEmpty()){
            return false
        }

        //case for confirmPassword not matching password
        if(confirmPassword != password){
            return false
        }

        //case for password not meeting strength requirements
        if (!password.matches((passwordRequirementsPattern.toRegex()))){
            return false
        }

        // passed all cases...valid return
        return true
    }
}