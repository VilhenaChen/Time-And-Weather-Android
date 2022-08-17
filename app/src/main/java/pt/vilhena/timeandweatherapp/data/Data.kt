package pt.vilhena.timeandweatherapp.data

import android.util.Log
import pt.vilhena.timeandweatherapp.model.GridItemAdapter
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

    // Function to get the current weather information for the current location
    fun getWeatherCurrentLocation(lat: Double, long: Double) {
        val call = RetrofitInitializer().weatherService()
            .getWeatherbyLatAndLong(lat.toString(), long.toString(), apiKey)
        call.enqueue(object : Callback<WeatherResponse?> {
            override fun onResponse(
                call: Call<WeatherResponse?>,
                response: Response<WeatherResponse?>
            ) {
                if (response.body() != null) {
                    val weather = response.body()
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
                Log.d(TAG, "Error gettin API information for current location")
            }
        })
    }

    // Function to get the current weather information for the default cities
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
                        val weather = response.body()
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
                    Log.d(TAG, "Error gettin API information " + t.message)
                }
            })
        }
    }
}