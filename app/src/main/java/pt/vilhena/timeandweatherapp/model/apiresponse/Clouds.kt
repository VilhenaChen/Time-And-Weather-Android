package pt.vilhena.timeandweatherapp.model.apiresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Clouds {
    @SerializedName("all")
    @Expose
    private var all = 0

    fun getAll(): Int {
        return all
    }

    fun setAll(all: Int) {
        this.all = all
    }
}