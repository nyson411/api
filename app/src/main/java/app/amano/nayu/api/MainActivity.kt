package app.amano.nayu.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.open-meteo.com/v1/")
        .build()
        .create(ApiInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val response = getCurrentWeather()
            Log.d("response ", response.toString())
        }

    }

    suspend fun getCurrentWeather(): ApiResponse? {
        try {
            val response: ApiResponse = api.getCurrentWeather()
            return response
        } catch (e: Exception) {
            return null
        }
    }

}