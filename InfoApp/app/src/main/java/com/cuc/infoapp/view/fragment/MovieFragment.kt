package com.cuc.infoapp.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder
import cn.bingoogolapple.refreshlayout.BGARefreshLayout
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Api
import com.cuc.infoapp.pojo.Movie
import com.cuc.infoapp.service.MovieBean
import com.cuc.infoapp.service.MovieService
import com.cuc.infoapp.view.adapter.MovieAdapter
import kotlinx.android.synthetic.main.news_or_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MovieFragment:Fragment() {
    private val dataItems: List<Movie> = ArrayList()

    // 创建Fragment的布局
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.news_or_movies, null, false)
        //refreshLayout=view.findViewById(R.id.itemsRefresh)
        //itemsRefresh.setDelegate()
        /*
        初始化BGARefreshLayout
        参考链接：https://blog.csdn.net/qq_33346062/article/details/89236894
         */

//        var refreshViewHolder=BGANormalRefreshViewHolder(context,true)
//        refreshViewHolder.setLoadingMoreText("加载更多")
//        refreshViewHolder.setLoadMoreBackgroundDrawableRes(R.drawable.button)   //  设置整个加载更多控件的背景
//        refreshViewHolder.setRefreshViewBackgroundDrawableRes(R.drawable.button)   //设置下拉刷新控件的背景
//
//        itemsRefresh.setRefreshViewHolder(refreshViewHolder)
//
//        itemsRefresh.beginRefreshing();
        return view
    }

    //  当Activity完成onCreate()时调用
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //瀑布流
        val layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        itemsRecyclerView.layoutManager=layoutManager

        itemsRecyclerView.adapter=MovieAdapter(getMovies(getTitleKey(), 0))  //模糊查询关键词

    }

    /*访问网络获取数据*/
    private fun getMovies(title: String, smode: Int):List<Movie>{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://v.juhe.cn/movie/")   //基址
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        lateinit var back: MovieBean
        var moviesData: List<Movie> = ArrayList()

        val movieService = retrofit.create(MovieService::class.java)
        movieService.getMovieData(Api().moviekey,title,smode)
            .enqueue(object : Callback<MovieBean> {
                override fun onResponse(call: Call<MovieBean>, response: Response<MovieBean>) {
                    if(response.isSuccessful){
                        back = response.body()!!
                        moviesData = back.result
                        //将数据放到适配器
                        if (moviesData!=null)
                        {
                            itemsRecyclerView.adapter=MovieAdapter(moviesData)
                        }
                    }
                }
                override fun onFailure(call: Call<MovieBean>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        return moviesData
    }
    //产生随机关键词用于获取初始电影页面数据
    private fun getTitleKey():String{
        var key : String = ""
        val list = mutableListOf<String>("人鱼","行动","逃亡","我们","奇缘","历险记","少年","笔记","哥斯拉","风云","传奇","时光","归来","疯狂","伟大","游记")
        list.shuffled().take(1).forEach{
            key = it.toString()
        }
        return key
    }
}