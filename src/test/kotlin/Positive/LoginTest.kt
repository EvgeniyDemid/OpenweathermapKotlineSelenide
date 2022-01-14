package Positive

import SetUp.SetUp
import com.codeborne.selenide.Condition
import com.codeborne.selenide.WebDriverRunner.url
import constants.Constant.EMAIL
import constants.Constant.PASSWORD
import constants.Constant.TEXT_TITEL_SIGN_IN
import constants.Constant.URL_REDIRECT_SIGNIN
import org.junit.Assert
import org.junit.jupiter.api.Test

class LoginTest: SetUp() {
    @Test
    fun login(){
        mainPage.signInButtonClick()
        signInPage.titelPageSignIn().shouldHave(Condition.text(TEXT_TITEL_SIGN_IN))
        Assert.assertEquals(URL_REDIRECT_SIGNIN, url())
        signInPage.writeEmailFild(EMAIL)
        signInPage.writePasswordFild(PASSWORD)
        signInPage.clickrememberMeCheckbox()
        signInPage.submitButtonElement().click()
    }
}