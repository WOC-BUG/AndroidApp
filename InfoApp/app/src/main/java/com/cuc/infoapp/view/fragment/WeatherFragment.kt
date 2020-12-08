package com.cuc.infoapp.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Weather
import com.cuc.infoapp.view.adapter.WeatherAdapter
import kotlinx.android.synthetic.main.weather_content.*
import java.util.ArrayList

class WeatherFragment: Fragment() {
    private val weatherItems: List<Weather> = ArrayList()

    // 创建Fragment的布局
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.weather_content, null, false)
        return view
    }

    //  当Activity完成onCreate()时调用
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutManager= LinearLayoutManager(context)
        layoutManager.orientation= LinearLayoutManager.VERTICAL    //垂直排列
        futureWeatherRecyclerView.layoutManager=layoutManager
        //itemsRecyclerView.adapter=NewsAdapter(dataItems)
        futureWeatherRecyclerView.adapter= WeatherAdapter(getWeather())

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getWeather():List<Weather>{
        val weatherList= ArrayList<Weather>()
        for(i in 1..7){
            val weather= Weather()
            weather.setCityName("北京")
            weather.setDate("2020年12月8日")
            weather.setTemperature("3°C")
            weather.setWeatherImage(this.resources.getDrawable(R.drawable.weather1))
            weatherList.add(weather)
        }
        return weatherList
    }
}