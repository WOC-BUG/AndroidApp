package com.cuc.infoapp.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Future
import com.cuc.infoapp.view.holder.WeatherHolder
import kotlinx.android.synthetic.main.future_weather.view.*

class WeatherAdapter(private val futureList: List<Future>) : RecyclerView.Adapter<WeatherHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.future_weather, parent, false)
        return WeatherHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        val future = futureList[position]
        holder.weatherItem.futureTemperature.text=future.temperature
        holder.weatherItem.futureDate.text=future.date
        holder.weatherItem.futureWeatherInfo.text=future.weather+" | "+future.direct
    }

    override fun getItemCount(): Int = futureList.size
}