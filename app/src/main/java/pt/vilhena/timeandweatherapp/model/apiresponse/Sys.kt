package pt.vilhena.timeandweatherapp.model.apiresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sys {
    @SerializedName("type")
    @Expose
    private var type = 0

    @SerializedName("id")
    @Expose
    private var id = 0

    @SerializedName("country")
    @Expose
    private var country: String? = null

    @SerializedName("sunrise")
    @Expose
    private var sunrise = 0

    @SerializedName("sunset")
    @Expose
    private var sunset = 0

    fun getType(): Int {
        return type
    }

    fun setType(type: Int) {
        this.type = type
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun getSunrise(): Int {
        return sunrise
    }

    fun setSunrise(sunrise: Int) {
        this.sunrise = sunrise
    }

    fun getSunset(): Int {
        return sunset
    }

    fun setSunset(sunset: Int) {
        this.sunset = sunset
    }
}