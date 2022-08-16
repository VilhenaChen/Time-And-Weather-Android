package pt.vilhena.timeandweatherapp.model.apiresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Main: Serializable {
    @SerializedName("temp")
    @Expose
    private var temp = 0f

    @SerializedName("feels_like")
    @Expose
    private var feelsLike = 0f

    @SerializedName("temp_min")
    @Expose
    private var tempMin = 0f

    @SerializedName("temp_max")
    @Expose
    private var tempMax = 0f

    @SerializedName("pressure")
    @Expose
    private var pressure = 0

    @SerializedName("humidity")
    @Expose
    private var humidity = 0

    fun getTemp(): Float {
        return temp
    }

    fun setTemp(temp: Float) {
        this.temp = temp
    }

    fun getFeelsLike(): Float {
        return feelsLike
    }

    fun setFeelsLike(feelsLike: Float) {
        this.feelsLike = feelsLike
    }

    fun getTempMin(): Float {
        return tempMin
    }

    fun setTempMin(tempMin: Float) {
        this.tempMin = tempMin
    }

    fun getTempMax(): Float {
        return tempMax
    }

    fun setTempMax(tempMax: Float) {
        this.tempMax = tempMax
    }

    fun getPressure(): Int {
        return pressure
    }

    fun setPressure(pressure: Int) {
        this.pressure = pressure
    }

    fun getHumidity(): Int {
        return humidity
    }

    fun setHumidity(humidity: Int) {
        this.humidity = humidity
    }
}