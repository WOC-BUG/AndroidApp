package com.cuc.infoapp.pojo

import android.graphics.drawable.Drawable
import android.media.Image
import android.widget.ImageView
import com.bumptech.glide.load.engine.Resource
import com.cuc.infoapp.R
import java.io.Serializable

class Weather:Serializable {
    private lateinit var cityName:String    //城市
    private lateinit var date:String    //日期
    private lateinit var temperature:String //当前温度
    private lateinit var weather:String //天气
    private lateinit var weatherId_fa:String //天气编号a
    private lateinit var weatherId_fb:String //天气编号b
    private lateinit var weatherImage:Drawable //天气图标

    fun setCityName(name:String){
        this.cityName=name
    }
    fun setDate(date:String){
        this.date=date
    }
    fun setTemperature(temperature:String){
        this.temperature=temperature
    }
    fun setWeather(weather:String){
        this.weather=weather
    }
    fun setWeatherIdFa(fa:String){
        this.weatherId_fa=fa
    }
    fun setWeatherIdFb(fb:String){
        this.weatherId_fa=fb
    }
    fun setWeatherImage(image:Drawable){
        this.weatherImage=image
    }

    fun getCityName():String{
        return this.cityName
    }
    fun getDate():String{
        return this.date
    }
    fun getTemperature():String{
        return this.temperature
    }
    fun getWeather():String{
        return weather
    }
    fun getWeatherIdFa():String{
        return this.weatherId_fa
    }
    fun getWeatherIdFb():String{
        return this.weatherId_fb
    }
    fun getWeatherImage():Drawable{
        return this.weatherImage
    }
}