package pt.vilhena.timeandweatherapp.data

import android.content.res.Resources
import android.util.Log
import pt.vilhena.timeandweatherapp.R
import pt.vilhena.timeandweatherapp.data.retrofit.RetrofitInitializer
import pt.vilhena.timeandweatherapp.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Data {
    // API Key for the OpenWeatherAPI
    val apiKey = "89091a130eb1583961e45663f9068cce"
    var citiesWeather = ArrayList<WeatherResponse>()
    val TAG = "Weather App Log"

    fun getWeather() {

        val defaultCities = arrayOf("Lisbon", "Madrid", "Paris", "Berlin", "Copenhagen", "Rome", "London", "Dublin", "Prague", "Vienna")

        for (index in defaultCities) {
            val call = RetrofitInitializer().weatherService()
                .getWeatherbyName(index, apiKey)
            call.enqueue(object : Callback<WeatherResponse?> {
                override fun onResponse(
                    call: Call<WeatherResponse?>,
                    response: Response<WeatherResponse?>
                ) {
                    Log.d(TAG, "Web Response code: ${response.code()}")
                    if (response.body() != null) {
                        var weather = response.body()
                        if (weather != null) {
                            citiesWeather.add(weather)
                            Log.d(TAG, "Weather on ${weather.getName()} is ${
                                weather.getMain()?.getTemp()
                            }")
                        } else {
                            println("NULL")
                        }
                    }
                }

                override fun onFailure(call: Call<WeatherResponse?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}