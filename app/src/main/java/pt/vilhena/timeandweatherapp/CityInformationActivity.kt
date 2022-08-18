package pt.vilhena.timeandweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import pt.vilhena.timeandweatherapp.model.WeatherResponse

class CityInformationActivity : AppCompatActivity() {
    private lateinit var cityName: String
    private lateinit var weather: WeatherResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_information)

        // Get the data sent from the other view
        cityName = intent.getStringExtra("cityName").toString()
        weather = intent.getSerializableExtra("cityWeather") as WeatherResponse

        viewBindings()
    }

    private fun viewBindings() {
        val image: ImageView = findViewById(R.id.weatherImage)
        val cityName: TextView = findViewById(R.id.cityName)
        val weatherDescription: TextView = findViewById(R.id.weatherDescription)
        val currentTemperature: TextView = findViewById(R.id.currentTemperature)
        val minMaxTemperature: TextView = findViewById(R.id.minMaxTemp)
        val humidity: TextView = findViewById(R.id.humidity)
        val wind: TextView = findViewById(R.id.wind)

        val icon = weather.getWeather()?.get(0)?.getIcon()

        val iconURL = "http://openweathermap.org/img/wn/$icon.png"
        Picasso.get().load(iconURL).placeholder(R.drawable._0d).into(image)

        cityName.text = String.format(getString(R.string.CityNameUI), this.cityName, weather.getSys()?.getCountry())
        weatherDescription.text = weather.getWeather()?.get(0)?.getDescription()
        currentTemperature.text = String.format(getString(R.string.TemperatureUI), weather.getMain()?.getTemp())
        minMaxTemperature.text = String.format(getString(R.string.MinMaxTempUI), weather.getMain()?.getTempMin(), weather.getMain()?.getTempMax())
        humidity.text = String.format(getString(R.string.HumitidyUI, weather.getMain()?.getHumidity()))
        wind.text = String.format(getString(R.string.WindUI), weather.getWind()?.getSpeed())
    }
}