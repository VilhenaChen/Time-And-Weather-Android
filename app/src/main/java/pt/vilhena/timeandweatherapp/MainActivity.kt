package pt.vilhena.timeandweatherapp

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import pt.vilhena.timeandweatherapp.data.Data
import pt.vilhena.timeandweatherapp.model.CityModel
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    val data = Data()
    var lat: Double = 0.0
    var long: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 2)
        }

        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                lat = location.latitude
                long = location.longitude
            }
        }

        gridView = findViewById(R.id.grid)
        var gridAdapter = GridItemAdapter(applicationContext, data.citiesArrayList)
        data.gridAdapter = gridAdapter
        gridView.adapter = gridAdapter
        data.getWeatherCurrentLocation(lat,long)
        data.getWeatherFromAPI()
        gridView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(applicationContext, "You clicked on " + data.citiesArrayList[+i].name,
            Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CityInformation_Activity::class.java)
            intent.putExtra("cityName", data.citiesArrayList[+i].name)
            intent.putExtra("cityWeather", data.citiesArrayList[+i].currentWeather)
            startActivity(intent)
        }

    }

//    private fun setCities(): ArrayList<CityModel> {
//       val data = Data()
//        data.getWeatherFromAPI()
//
//        val arrayList: ArrayList<CityModel> = ArrayList()
//        arrayList.add(CityModel("Current Location", "00:00"))
//        arrayList.add(CityModel("Lisboa", "00:00"))
//        arrayList.add(CityModel("Madrid", "00:00"))
//        arrayList.add(CityModel("Paris", "00:00"))
//        arrayList.add(CityModel("Berlim", "00:00"))
//        arrayList.add(CityModel("Copenhaga", "00:00"))
//        arrayList.add(CityModel("Roma", "00:00"))
//        arrayList.add(CityModel("Londres", "00:00"))
//        arrayList.add(CityModel("Dublin", "00:00"))
//        arrayList.add(CityModel("Praga", "00:00"))
//        arrayList.add(CityModel("Viena", "00:00"))
//
//        return arrayList
//    }
}