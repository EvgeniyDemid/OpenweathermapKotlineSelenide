package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.`$x`
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverRunner.url

class SignInPage: MainPage() {

    private  val emailFild:SelenideElement= `$x`("//div[@class='input-group']//input[@id='user_email']")
    private val passwordFild:SelenideElement=`$x`("//input[@id='user_password']")
    private  val rememberMeCheckbox:SelenideElement=`$x`("//label[@class='boolean optional']")
    private val submitButton:SelenideElement=`$x`("//div[@class='sign-form']/form[@id='new_user']/input[3]")
    private  val titelPage:SelenideElement=`$x`("//h3[@class='first-child']")


    fun writeEmailFild(emai:String): pages.SignInPage {
        emailFild.shouldBe(Condition.visible,).sendKeys(emai)
        return this
    }
    fun  writePasswordFild(password:String): pages.SignInPage {
        passwordFild.shouldBe(Condition.visible).sendKeys(password)
        return this
    }
    fun clickrememberMeCheckbox(): pages.SignInPage {
        rememberMeCheckbox.shouldBe(Condition.visible).click()
       return this
    }

    fun titelPageSignIn(): SelenideElement {
        return titelPage
    }
    fun submitButtonElement(): SelenideElement {
        return submitButton
    }

}

