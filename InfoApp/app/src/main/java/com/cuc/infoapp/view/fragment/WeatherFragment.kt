package com.cuc.infoapp.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Api
import com.cuc.infoapp.pojo.WeatherResponse
import com.cuc.infoapp.view.adapter.WeatherAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.today_weather.*
import kotlinx.android.synthetic.main.weather_content.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class WeatherFragment(): Fragment() {
    var api:Api=Api()
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
        //api.cityName=cityname
        sendRequest()
    }

    @SuppressLint("SetTextI18n")
    private fun showResponse(response: String) {
        println(response)
        val gson = Gson()
        val weather: WeatherResponse =gson.fromJson(response,
            WeatherResponse::class.java)
        //今日天气
        currentTemperature.text=weather.result.realtime.temperature+"°C"//weather.result.sk.temp+"°C"
        todayTemperature.text="湿度:"+weather.result.realtime.humidity//weather.result.today.temperature
        city.text=weather.result.city//weather.result.today.city
        otherInfo.text=weather.result.realtime.info+" | "+weather.result.realtime.direct//weather.result.today.weather +" | "+ weather.result.today.wind
        //未来7日天气RecyclerView
        futureWeatherRecyclerView.adapter= WeatherAdapter(weather.result.future)
    }

    private fun sendRequest(){
        thread{
            var connection: HttpURLConnection? = null
            try{
                var response = StringBuilder()
                val url= URL(api.getWeather)
                connection = url.openConnection() as HttpURLConnection  //连接
                connection.requestMethod = "GET";
                connection.connectTimeout = 8000
                connection.readTimeout = 8000
                val input = connection.inputStream //获取输入流

                //对获取到的输入流进行读取
                val reader = BufferedReader (InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                showResponse(response.toString())
            }catch (e:Exception){
                e.printStackTrace()
            }finally {
                connection?.disconnect()
            }
        }
    }

}