package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.matchText
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import constants.Constant.WAITTIME
import org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable
import java.time.Duration


open class MainPage {
    private  val signInButton:SelenideElement=`$x`("//li[@class='user-li']//a[contains(text(),'Sign in')]")
    private val fildSearchCity:SelenideElement=`$x`("//div[@class='search-container']//input[@type='text']")
    private  val searchButton:SelenideElement=`$x`("//button[@type='submit']")
    private val searchDropdown:SelenideElement =`$x`("//ul[@class='search-dropdown-menu']")
    private val temperature:SelenideElement=`$x`("//span[@class='heading']")
    private val findCity:SelenideElement=`$x`("//h2[@style='margin-top: 0px;']")
    private val temperatureInFahrenheitButton:SelenideElement=`$x`("//div[contains(text(),'Imperial: °F, mph')]")
    private val temperatureInCelsiusButton:SelenideElement=`$x`("//div[contains(text(),'Metric: °C, m/s')]")
    private val loader:SelenideElement=`$x`("//div[@class='owm-loader-container']")

    fun waiting(){
        loader.shouldNotBe(Condition.visible, Duration.ofSeconds(WAITTIME))
    }

    fun signInButtonClick(): SignInPage {
        signInButton.shouldBe(Condition.enabled, Duration.ofSeconds(WAITTIME)).click()
        return SignInPage()
    }
    fun findCityTemperature(city:String){
        fildSearchCity.shouldBe(Condition.visible).setValue(city)
        searchButton.shouldBe(Condition.enabled).click()
        if(searchDropdown.shouldBe(Condition.visible).findAll("li").size!=0){
            searchDropdown.shouldBe(Condition.visible).findAll("li").get(0).click()
            searchDropdown.shouldNotBe(Condition.visible)
            findCity.should(matchText(city))
        } else{
            println("THIS CITY IS NOT FOUND")
        }
    }
    fun getTemperature():String{
        return temperature.text
    }

    fun clickTemperatureInFahrenheitButton(): MainPage {
        temperatureInFahrenheitButton.shouldBe(Condition.enabled).click()
        waiting()
        return this
    }
    fun clickTemperatureInCelsiusButton(): MainPage {
        temperatureInCelsiusButton.shouldBe(Condition.enabled).click()
        waiting()
        return this
    }

}