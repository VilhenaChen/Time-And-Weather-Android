package pt.vilhena.timeandweatherapp.data.retrofit

import pt.vilhena.timeandweatherapp.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather?")
    fun getWeatherbyLatAndLong(@Query("lat") lat: String, @Query("lon") lon: String, @Query("APPID") app_id: String, @Query("units") units: String = "metric") : Call<WeatherResponse>

    @GET("data/2.5/weather?")
    fun getWeatherbyName(@Query("q") name: String, @Query("APPID") app_id: String, @Query("units") units: String = "metric") : Call<WeatherResponse>
}