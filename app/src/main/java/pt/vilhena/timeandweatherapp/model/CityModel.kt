package pt.vilhena.timeandweatherapp.model

class CityModel {

    var name: String? = null
    var currentTime: String? = null

    constructor(name: String?, currentTime: String?) {
        this.name = name
        this.currentTime = currentTime
    }
}