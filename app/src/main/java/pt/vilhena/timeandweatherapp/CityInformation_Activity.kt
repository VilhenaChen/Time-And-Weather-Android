package pt.vilhena.timeandweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import pt.vilhena.timeandweatherapp.model.WeatherResponse
import java.lang.Exception

class CityInformation_Activity : AppCompatActivity() {
    private lateinit var cityName: String
    private lateinit var weather: WeatherResponse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_information)

        cityName = intent.getStringExtra("cityName").toString()
        weather = intent.getSerializableExtra("cityWeather") as WeatherResponse

        viewBindings()
    }

    fun viewBindings() {
        val image: ImageView = findViewById(R.id.weatherImage)
        val cityNameTextView: TextView = findViewById(R.id.cityNameTextField)
        val cityWeatherTextView: TextView = findViewById(R.id.temperature)
        val feelsLike: TextView = findViewById(R.id.fellsLike)
        val minTemperature: TextView = findViewById(R.id.minTemp)
        val maxTemperature: TextView = findViewById(R.id.maxTemp)

        val icon = weather.getWeather()?.get(0)?.getIcon()

        val iconURL = "http://openweathermap.org/img/wn/" + icon +".png"
        Picasso.get().load(iconURL).into(image)

        cityNameTextView.text = cityName
        cityWeatherTextView.text = weather.getMain()?.getTemp().toString() + "º"
        feelsLike.text = weather.getMain()?.getFeelsLike().toString() + "º"
        minTemperature.text = weather.getMain()?.getTempMin().toString() + "º"
        maxTemperature.text = weather.getMain()?.getTempMax().toString() + "º"

    }
}