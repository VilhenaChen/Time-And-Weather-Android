package pt.vilhena.timeandweatherapp.data

import android.util.Log
import pt.vilhena.timeandweatherapp.GridItemAdapter
import pt.vilhena.timeandweatherapp.data.retrofit.RetrofitInitializer
import pt.vilhena.timeandweatherapp.model.CityModel
import pt.vilhena.timeandweatherapp.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Data {
    // API Key for the OpenWeatherAPI
    val apiKey = "89091a130eb1583961e45663f9068cce"
    val TAG = "Weather App Log"

    lateinit var gridAdapter: GridItemAdapter

    var citiesArrayList = ArrayList<CityModel>()

    fun getWeatherCurrentLocation(lat: Double, long: Double) {
        val call = RetrofitInitializer().weatherService()
            .getWeatherbyLatAndLong(lat.toString(), long.toString(), apiKey)
        call.enqueue(object : Callback<WeatherResponse?> {
            override fun onResponse(
                call: Call<WeatherResponse?>,
                response: Response<WeatherResponse?>
            ) {
                if (response.body() != null) {
                    var weather = response.body()
                    if (weather != null) {
                        citiesArrayList.add(CityModel("Current Location", weather))
                        Log.d(TAG, "Weather on ${weather.getName()} is ${
                            weather.getMain()?.getTemp()
                        }")
                        citiesArrayList.sortWith(compareBy({ it.name }))
                        gridAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<WeatherResponse?>, t: Throwable) {

            }
        })
    }

    fun getWeatherFromAPI() {

        val defaultCities = arrayOf("Lisbon", "Madrid", "Paris", "Berlin", "Copenhagen", "Rome", "London", "Dublin", "Prague", "Vienna")
        for (index in defaultCities) {
            val call = RetrofitInitializer().weatherService()
                .getWeatherbyName(index, apiKey)
            call.enqueue(object : Callback<WeatherResponse?> {
                override fun onResponse(
                    call: Call<WeatherResponse?>,
                    response: Response<WeatherResponse?>
                ) {
                    if (response.body() != null) {
                        var weather = response.body()
                        if (weather != null) {
                            citiesArrayList.add(CityModel(weather.getName(), weather))
                            Log.d(TAG, "Weather on ${weather.getName()} is ${
                                weather.getMain()?.getTemp()
                            }")
                            citiesArrayList.sortWith(compareBy({ it.name }))
                            gridAdapter.notifyDataSetChanged()
                        }
                    }
                }

                override fun onFailure(call: Call<WeatherResponse?>, t: Throwable) {
                }
            })
        }
    }
}