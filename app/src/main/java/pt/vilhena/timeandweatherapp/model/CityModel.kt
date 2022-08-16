package pt.vilhena.timeandweatherapp.model

class CityModel {

    var name: String? = null
    var currentWeather: WeatherResponse? = null

    constructor(name: String?, currentWeather: WeatherResponse?) {
        this.name = name
        this.currentWeather = currentWeather
    }
}