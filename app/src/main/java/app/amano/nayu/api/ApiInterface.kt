package app.amano.nayu.api

import retrofit2.http.GET


interface ApiInterface {
        @GET("forecast?latitude=35.6785&longitude=139.6823&current_weather=true")
        suspend fun getCurrentWeather(): ApiResponse
}
