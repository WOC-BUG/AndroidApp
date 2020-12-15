package com.cuc.infoapp.view.fragment

import android.annotation.SuppressLint
import android.content.Intent
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
import com.cuc.infoapp.view.activity.ChatActivity
import com.cuc.infoapp.view.adapter.WeatherAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.today_weather.*
import kotlinx.android.synthetic.main.weather_content.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread


class WeatherFragment(private var api:Api): Fragment() {
    var thread= Thread()
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
        sendRequest()
    }

    // 更新UI
    private val handler= @SuppressLint("HandlerLeak")
    object : Handler(){
        override fun handleMessage(msg: Message) {
            val gson = Gson()
            val weather: WeatherResponse =gson.fromJson(msg.data.getString("data"),WeatherResponse::class.java)
            when(msg.what){
                1-> {
                    println("weather update")
                    //今日天气
                    currentTemperature.text=weather.result.realtime.temperature+"°C"
                    todayTemperature.text="湿度:"+weather.result.realtime.humidity
                    city.text=weather.result.city
                    otherInfo.text=weather.result.realtime.info+" | "+weather.result.realtime.direct
                    //未来7日天气RecyclerView
                    futureWeatherRecyclerView.adapter= WeatherAdapter(weather.result.future)
                }
            }
        }
    }

    fun sendRequest()
    {
        thread{
            var connection: HttpURLConnection? = null
            try{
//                val bundle1 = this.arguments //得到从Activity传来的数据
//                if (bundle1 != null) {
//                    api.cityName=bundle1.getString("cityName").toString()
//                }
                val response = StringBuilder()
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

                //通过handler发送message传参，在主线程更新UI
                val bundle=Bundle()
                bundle.putString("data",response.toString())
                val msg= Message()
                msg.what=1
                msg.data=bundle
                handler.sendMessage(msg)
            }catch (e:Exception){
                e.printStackTrace()
            }finally {
                connection?.disconnect()
            }
        }
    }
}