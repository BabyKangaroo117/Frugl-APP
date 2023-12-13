
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.frugl_app.ui.login.Login
import com.example.frugl_app.ui.main.MainActivity
import com.example.frugl_app.ui.signup.SignUp
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @Test // Testing login button functionality
    fun testLoginButtonLaunchesLoginActivity() {
        onView(withId(com.example.frugl_app.R.id.login)).perform(click())
        Intents.intended(hasComponent(Login::class.java.name))
    }

    @Test // Testing signup button functionality
    fun testSignUpButtonLaunchesSignUpActivity() {
        onView(withId(com.example.frugl_app.R.id.signup)).perform(click())
        Intents.intended(hasComponent(SignUp::class.java.name))
    }

    @After
    fun tearDown() {
        Intents.release()
    }
}
