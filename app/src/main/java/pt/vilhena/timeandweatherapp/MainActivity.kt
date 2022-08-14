package pt.vilhena.timeandweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import pt.vilhena.timeandweatherapp.data.Data
import pt.vilhena.timeandweatherapp.data.retrofit.RetrofitInitializer
import pt.vilhena.timeandweatherapp.model.CityModel
import pt.vilhena.timeandweatherapp.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.grid)
        val citiesArray = setCities()
        var gridAdapter = GridItemAdapter(applicationContext, citiesArray)
        gridView.adapter = gridAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(applicationContext, "You clicked on " + citiesArray[+i].name,
            Toast.LENGTH_SHORT).show()
        }

    }

    private fun setCities(): ArrayList<CityModel> {
       val data = Data()
        data.getWeather()

        val arrayList: ArrayList<CityModel> = ArrayList()
        arrayList.add(CityModel("Current Location", "00:00"))
        arrayList.add(CityModel("Lisboa", "00:00"))
        arrayList.add(CityModel("Madrid", "00:00"))
        arrayList.add(CityModel("Paris", "00:00"))
        arrayList.add(CityModel("Berlim", "00:00"))
        arrayList.add(CityModel("Copenhaga", "00:00"))
        arrayList.add(CityModel("Roma", "00:00"))
        arrayList.add(CityModel("Londres", "00:00"))
        arrayList.add(CityModel("Dublin", "00:00"))
        arrayList.add(CityModel("Praga", "00:00"))
        arrayList.add(CityModel("Viena", "00:00"))

        return arrayList
    }

}