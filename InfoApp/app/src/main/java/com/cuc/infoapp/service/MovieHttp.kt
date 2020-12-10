//package com.cuc.infoapp.service
//
//import android.util.Log
//import com.cuc.infoapp.pojo.Movie
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
////网络请求
//class MovieHttp() {
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl("http://v.juhe.cn/movie/")   //基址
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    private lateinit var back: MovieBean
//    private var moviesData: List<Movie> = ArrayList()
//    private val moviesList=ArrayList<Movie>()
//
//    fun getMovies(title: String): List<Movie>{
//
//        val movieService = retrofit.create(MovieService::class.java)
//        movieService.getMovieData("e97579555ffaca1a38be537090e108a6",title)
//            .enqueue(object : Callback<MovieBean>{
//                override fun onResponse(call: Call<MovieBean>, response: Response<MovieBean>) {
//                    if(response.isSuccessful){
//                        back = response.body()!!
//                        moviesData = back.result
//                        for(i in moviesData.indices){
//                            var movie :Movie = moviesData[i]
//                            moviesList.add(movie)
//                        }
//
//                        if(moviesList != null){
//                            for(i in moviesList.indices){
//                                Log.d("MovieHttp",moviesList[i].actors)
//                                Log.d("MovieHttp",moviesList[i].title)
//                                Log.d("MovieHttp","成功获取数据！")
//                                println(moviesData)
//
//                            }
//
//                        }
//
//                    }
//
//                }
//
//                override fun onFailure(call: Call<MovieBean>, t: Throwable) {
//                    t.printStackTrace()
//                    //fail(t.toString)
//                }
//            })
//
//        //return moviesData
//        return moviesList
//    }
//
//}