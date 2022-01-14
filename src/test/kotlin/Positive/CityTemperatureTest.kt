package Positive

import SetUp.SetUp
import org.junit.Assert
import org.junit.jupiter.api.Test

class CityTemperatureTest: SetUp() {
    val cities=listOf("Moscow","London","Yoshkar-Ola")
    var temperatureCelsius: Double? =null
    var temperatureInFahrenheit:Int?=null

    @Test
    fun cityTemperature(){

        cities.forEach{
            mainPage.findCityTemperature(it)
            temperatureCelsius=mainPage.getTemperature().dropLast(2).toDouble()
            println("Температура в цельсиях ")
            println(temperatureCelsius)
            mainPage.clickTemperatureInFahrenheitButton()
            temperatureInFahrenheit=mainPage.getTemperature().dropLast(2).toInt()
            println("Темература в фарингейтах")
            println(temperatureInFahrenheit)
            mainPage.clickTemperatureInCelsiusButton()
            Assert.assertEquals(temperatureInFahrenheit,(Math.ceil((temperatureCelsius!! * 1.8) + 32)).toInt())
        }

    }
}