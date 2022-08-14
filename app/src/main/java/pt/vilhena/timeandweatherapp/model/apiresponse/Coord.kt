package pt.vilhena.timeandweatherapp.model.apiresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coord {
    @SerializedName("lon")
    @Expose
    private var lon = 0f

    @SerializedName("lat")
    @Expose
    private var lat = 0f

    fun getLon(): Float {
        return lon
    }

    fun setLon(lon: Float) {
        this.lon = lon
    }

    fun getLat(): Float {
        return lat
    }

    fun setLat(lat: Float) {
        this.lat = lat
    }
}