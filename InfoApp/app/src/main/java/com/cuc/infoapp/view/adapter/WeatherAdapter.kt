package com.cuc.infoapp.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Weather
import com.cuc.infoapp.view.holder.WeatherHolder
import kotlinx.android.synthetic.main.future_weather.view.*

class WeatherAdapter(private val weatherList: List<Weather>) : RecyclerView.Adapter<WeatherHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.future_weather, parent, false)
        return WeatherHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        val weather = weatherList[position]
        holder.weatherItem.date.text = weather.getDate()
        holder.weatherItem.temperature.text = weather.getTemperature()
        holder.weatherItem.weatherIcon.setImageDrawable(weather.getWeatherImage())
    }

    override fun getItemCount(): Int = weatherList.size
}