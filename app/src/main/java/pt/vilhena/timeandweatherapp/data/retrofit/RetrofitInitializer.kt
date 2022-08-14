package pt.vilhena.timeandweatherapp.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// This can also be named RetrifitConfig, WebClient etc...
class RetrofitInitializer {

    // Responsible for creating Retrofit objects
    // The baseURl is the url used to make every request
    // Using the GSON converter to convert the JSON to java class
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun weatherService() : WeatherService{
        return retrofit.create(WeatherService::class.java)
    }
}