package pt.vilhena.timeandweatherapp.model.apiresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wind {
    @SerializedName("speed")
    @Expose
    private var speed = 0f

    @SerializedName("deg")
    @Expose
    private var deg = 0

    @SerializedName("gust")
    @Expose
    private var gust = 0f

    fun getSpeed(): Float {
        return speed
    }

    fun setSpeed(speed: Float) {
        this.speed = speed
    }

    fun getDeg(): Int {
        return deg
    }

    fun setDeg(deg: Int) {
        this.deg = deg
    }

    fun getGust(): Float {
        return gust
    }

    fun setGust(gust: Float) {
        this.gust = gust
    }
}