package com.cuc.infoapp.service

import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.cuc.infoapp.pojo.Api
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class SendRequest {
    // 获取网络数据的子线程
    fun sendRequest(api:String,handler:Handler){
        thread{
            var connection: HttpURLConnection? = null
            try{
                val response = StringBuilder()
                val url= URL(api)
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
                val bundle= Bundle()
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