package com.cuc.infoapp.view.holder

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R

class WeatherHolder(view:View):RecyclerView.ViewHolder(view) {
    val weatherItem:LinearLayout=view.findViewById(R.id.futureWeatherItem)
}