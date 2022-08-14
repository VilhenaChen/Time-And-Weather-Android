package pt.vilhena.timeandweatherapp.model

class CityModel {

    var name: String? = null
    var currentTemperature: String? = null

    constructor(name: String?, currentTemperature: String?) {
        this.name = name
        this.currentTemperature = currentTemperature
    }
}