package pt.vilhena.timeandweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import pt.vilhena.timeandweatherapp.model.WeatherResponse

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
        val cityName: TextView = findViewById(R.id.cityName)
        //val weatherDescription: TextView = findViewById(R.id.weatherDescription)
        val currentTemperature: TextView = findViewById(R.id.currentTemperature)
        //val feelsLike: TextView = findViewById(R.id.fellsLike)
        val minMaxTemperature: TextView = findViewById(R.id.minMaxTemp)
        //val maxTemperature: TextView = findViewById(R.id.maxTemp)

        val icon = weather.getWeather()?.get(0)?.getIcon()

        val iconURL = "http://openweathermap.org/img/wn/" + icon +".png"
        Picasso.get().load(iconURL).into(image)

        cityName.text = this.cityName
        //weatherDescription.text = weather.getWeather()?.get(0)?.getDescription()
        currentTemperature.text = weather.getMain()?.getTemp().toString() + "º"
        //feelsLike.text = weather.getMain()?.getFeelsLike().toString() + "º"
        minMaxTemperature.text = weather.getMain()?.getTempMin().toString() + "º" + "/" + weather.getMain()?.getTempMax().toString() + "º"
        //maxTemperature.text = weather.getMain()?.getTempMax().toString() + "º"

    }
}