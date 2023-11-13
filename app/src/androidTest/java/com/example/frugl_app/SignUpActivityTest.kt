package com.example.frugl_app

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SignUpActivityTest  {

    @get:Rule
    val activityRule = ActivityScenarioRule(SignUp::class.java)


}