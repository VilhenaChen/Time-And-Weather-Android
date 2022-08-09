package pt.vilhena.timeandweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import pt.vilhena.timeandweatherapp.model.CityModel
import java.time.Clock
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

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
            println(citiesArray[1])
        }
    }

    private fun setCities(): ArrayList<CityModel> {

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        var formatted = current.format(formatter)

        println("TESTE " + LocalDateTime.now(ZoneId.of("Europe/Paris"))  )

        var arrayList: ArrayList<CityModel> = ArrayList()
        arrayList.add(CityModel("Current Location", formatted))
        arrayList.add(CityModel("Lisboa", LocalDateTime.now(ZoneId.of("Europe/Lisbon")).format(formatter)))
        arrayList.add(CityModel("Madrid", LocalDateTime.now(ZoneId.of("Europe/Madrid")).format(formatter)))
        arrayList.add(CityModel("Paris", LocalDateTime.now(ZoneId.of("Europe/Paris")).format(formatter)))
        arrayList.add(CityModel("Berlim", LocalDateTime.now(ZoneId.of("Europe/Berlin")).format(formatter)))
        arrayList.add(CityModel("Copenhaga", LocalDateTime.now(ZoneId.of("Europe/Copenhagen")).format(formatter)))
        arrayList.add(CityModel("Roma", LocalDateTime.now(ZoneId.of("Europe/Rome")).format(formatter)))
        arrayList.add(CityModel("Londres", LocalDateTime.now(ZoneId.of("Europe/London")).format(formatter)))
        arrayList.add(CityModel("Dublin", LocalDateTime.now(ZoneId.of("Europe/Dublin")).format(formatter)))
        arrayList.add(CityModel("Praga", LocalDateTime.now(ZoneId.of("Europe/Prague")).format(formatter)))
        arrayList.add(CityModel("Viena", LocalDateTime.now(ZoneId.of("Europe/Vienna")).format(formatter)))

        return arrayList
    }
}