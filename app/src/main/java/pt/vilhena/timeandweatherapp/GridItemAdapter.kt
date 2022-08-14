package pt.vilhena.timeandweatherapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import pt.vilhena.timeandweatherapp.model.CityModel

class GridItemAdapter(
    private val context: Context,
    private val citiesName: ArrayList<CityModel>
) : BaseAdapter() {

    lateinit var cityNameTextView : TextView
    lateinit var cityTime : TextView

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
        cityTime = view.findViewById(R.id.cityTimeTextField)

        var choosedCity = citiesName[p0]

        cityNameTextView.text = choosedCity.name
        cityTime.text = choosedCity.currentTemperature

        return view
    }


}