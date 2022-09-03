package app.amano.nayu.api

data class ApiResponse (
    val current_weather: CurrentWeather
)

data class CurrentWeather (
    val time: String,
    val temperature: Float,
    val weathercode: Int,
    val windspeed: Float,
    val winddirection: Int,
)

