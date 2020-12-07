package com.cuc.infoapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder
import cn.bingoogolapple.refreshlayout.BGARefreshLayout
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Movie
import com.cuc.infoapp.view.adapter.MovieAdapter
import kotlinx.android.synthetic.main.news_or_movies.*
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
        itemsRecyclerView.adapter=MovieAdapter(getMovies())
    }

    private fun getMovies():List<Movie>{
        val moviesList=ArrayList<Movie>()
        for(i in 1..10){
            val movies=Movie()
            movies.setTitle("This is title $i")
            movies.setPoster("https://tu.tianzuida.com/pic/upload/vod/2019-11-22/201911221574404114.jpg")
            moviesList.add(movies)
        }
        return moviesList
    }
}