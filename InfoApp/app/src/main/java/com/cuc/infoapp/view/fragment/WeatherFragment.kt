package com.cuc.infoapp.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Api
import com.cuc.infoapp.pojo.WeatherResponse
import com.cuc.infoapp.service.SendRequest
import com.cuc.infoapp.view.adapter.WeatherAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.today_weather.*
import kotlinx.android.synthetic.main.weather_content.*


class WeatherFragment(private var api:Api): Fragment() {
    // 创建Fragment的布局
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_content, null, false)
    }

    //  当Activity完成onCreate()时调用
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutManager= LinearLayoutManager(context)
        layoutManager.orientation= LinearLayoutManager.VERTICAL    //垂直排列
        futureWeatherRecyclerView.layoutManager=layoutManager
        //发送请求获取数据
        SendRequest().sendRequest(api.getWeather,handler)
    }

    // 更新UI
    private val handler= @SuppressLint("HandlerLeak")
    object : Handler(){
        override fun handleMessage(msg: Message) {
            val gson = Gson()
            val weather: WeatherResponse =gson.fromJson(msg.data.getString("data"),WeatherResponse::class.java)
            if(weather.result!=null) {
                when (msg.what) {
                    1 -> {
                        println("weather update")
                        //今日天气
                        currentTemperature.text = weather.result.realtime.temperature + "°C"
                        todayTemperature.text = "湿度:" + weather.result.realtime.humidity
                        city.text = weather.result.city
                        otherInfo.text =
                            weather.result.realtime.info + " | " + weather.result.realtime.direct
                        //未来7日天气RecyclerView
                        futureWeatherRecyclerView.adapter = WeatherAdapter(weather.result.future)
                    }
                }
            }
        }
    }
}