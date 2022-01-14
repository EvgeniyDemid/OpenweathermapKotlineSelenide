package Positive

import Model.ResponseWeather
import constants.Constant.API_KEY
import constants.Constant.CITY_ID
import constants.Constant.URL_API
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.jupiter.api.Test

class WeatherAPITest {
    @Test
    fun api(){
        val respons =
            RestAssured.given()
                .baseUri(URL_API)
                .contentType(ContentType.JSON)
                .queryParam("appid", API_KEY)
                .queryParam("id",CITY_ID)
                .`when`().get()
                .then()
                .statusCode(200)
                .extract().response().`as`(ResponseWeather::class.java)

        println("Температура в городе Йошкар-Ола" + respons.main?.temp!!.minus(273.16).toInt())



    }
}
