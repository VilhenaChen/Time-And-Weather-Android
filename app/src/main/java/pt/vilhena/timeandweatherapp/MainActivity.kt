package pt.vilhena.timeandweatherapp

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import pt.vilhena.timeandweatherapp.data.Data
import pt.vilhena.timeandweatherapp.model.GridItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    val data = Data()
    var lat: Double = 0.0
    var long: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if the app has permission to access the user location
        if(ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 2)
        }

        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Get the last location, latitude and longitude
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                lat = location.latitude
                long = location.longitude
            }
        }

        gridView = findViewById(R.id.grid)
        val gridAdapter = GridItemAdapter(applicationContext, data.citiesArrayList)
        data.gridAdapter = gridAdapter
        gridView.adapter = gridAdapter

        data.getWeatherCurrentLocation(lat,long)
        data.getWeatherFromAPI()

        // When a city card is clicked, the activity with more detailed weather information is showed
        gridView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, CityInformation_Activity::class.java)
            intent.putExtra("cityName", data.citiesArrayList[+i].name)
            intent.putExtra("cityWeather", data.citiesArrayList[+i].currentWeather)
            startActivity(intent)
        }

    }

}