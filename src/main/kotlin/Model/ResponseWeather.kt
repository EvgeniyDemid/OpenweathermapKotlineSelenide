package Model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseWeather(
	val visibility: Int? = null,
	val timezone: Int? = null,
	val main: Main? = null,
	val clouds: Clouds? = null,
	val sys: Sys? = null,
	val dt: Int? = null,
	val coord: Coord? = null,
	val weather: List<WeatherItem?>? = null,
	val name: String? = null,
	val cod: Int? = null,
	val id: Int? = null,
	val base: String? = null,
	val wind: Wind? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Main(
	val temp: Double? = null,
	val tempMin: Double? = null,
	val grndLevel: Int? = null,
	val humidity: Int? = null,
	val pressure: Int? = null,
	val seaLevel: Int? = null,
	val feelsLike: Double? = null,
	val tempMax: Double? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Sys(
	val country: String? = null,
	val sunrise: Int? = null,
	val sunset: Int? = null,
	val id: Int? = null,
	val type: Int? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Coord(
	val lon: Double? = null,
	val lat: Double? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Wind(
	val deg: Int? = null,
	val speed: Double? = null,
	val gust: Double? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Clouds(
	val all: Int? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
data class WeatherItem(
	val icon: String? = null,
	val description: String? = null,
	val main: String? = null,
	val id: Int? = null
)

