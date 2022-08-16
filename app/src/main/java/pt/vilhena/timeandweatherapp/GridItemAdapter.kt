package pt.vilhena.timeandweatherapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import pt.vilhena.timeandweatherapp.model.CityModel
import java.lang.Exception

class GridItemAdapter(
    private val context: Context,
    private val citiesName: ArrayList<CityModel>
) : BaseAdapter() {

    lateinit var cityNameTextView : TextView
    lateinit var cityTemperature : TextView
    lateinit var cityHumidity: TextView
    lateinit var weatherImage: ImageView

    override fun getCount(): Int {
        return citiesName.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view: View = View.inflate(context, R.layout.grid_item, null)

        cityNameTextView = view.findViewById(R.id.cityNameTextField)
        cityTemperature = view.findViewById(R.id.temperature)
        cityHumidity = view.findViewById(R.id.humidity)
        weatherImage = view.findViewById(R.id.weatherImage)

        var choosedCity = citiesName[p0]
        val currentWeather = choosedCity.currentWeather?.getWeather()
        val icon = currentWeather?.get(0)?.getIcon()

        cityNameTextView.text = choosedCity.name
        cityTemperature.text = choosedCity.currentWeather?.getMain()?.getTemp().toString() + "º"
        cityHumidity.text = choosedCity.currentWeather?.getMain()?.getHumidity().toString() + "%"

        val iconURL = "http://openweathermap.org/img/wn/" + icon +".png"
        Picasso.get().load(iconURL).fit().into(weatherImage, object: Callback {
            override fun onSuccess() {
                println("Got Image from: " + choosedCity.name)
                notifyDataSetChanged()
            }

            override fun onError(e: Exception?) {
                println("URL: " + iconURL)
                e?.printStackTrace()
            }
        })


        return view
    }


}