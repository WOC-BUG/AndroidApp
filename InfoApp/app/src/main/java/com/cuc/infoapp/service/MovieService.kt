package com.cuc.infoapp.service

import com.cuc.infoapp.pojo.Movie
import retrofit2.http.GET

interface MovieService {
    @GET("index")
    fun getMovieData(
        @retrofit2.http.Query("key") key: String,
        @retrofit2.http.Query("title") title: String,
        @retrofit2.http.Query("smode") smode: Int    //是否精确查找，精确:1 模糊:0 默认1
    ): retrofit2.Call<MovieBean>
}