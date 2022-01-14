package SetUp

import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.sleep
import constants.Constant.SLEEP_TIME
import constants.Constant.URL
import org.junit.jupiter.api.BeforeEach
import pages.MainPage
import pages.SignInPage


open class SetUp {
    protected val signInPage=SignInPage()
    protected val mainPage=MainPage()
    @BeforeEach
   fun setUp(){
        open(URL)
        mainPage.waiting()

    }
}