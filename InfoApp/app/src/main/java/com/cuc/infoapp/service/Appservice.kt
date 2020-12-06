package com.cuc.infoapp.service

import com.cuc.infoapp.pojo.Msg
import retrofit2.http.GET

interface Appservice {
    @GET("api.php")
    fun getMessageByGet(@retrofit2.http.Query("key")key:String,
                        @retrofit2.http.Query("appid")appid:Int,
                        @retrofit2.http.Query("msg")msg:String): retrofit2.Call<Msg>

    @GET("api.php")
    fun getMessageByPost(@retrofit2.http.Query("key")key:String,
                         @retrofit2.http.Query("appid")appid:Int,
                         @retrofit2.http.Query("msg")msg:String): retrofit2.Call<Msg>
}