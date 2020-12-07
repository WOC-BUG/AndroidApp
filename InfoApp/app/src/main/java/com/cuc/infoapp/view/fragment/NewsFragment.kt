package com.cuc.infoapp.view.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.News
import com.cuc.infoapp.view.activity.MainActivity
import com.cuc.infoapp.view.activity.NewsActivity
import com.cuc.infoapp.view.adapter.NewsAdapter
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.item_news.*
import kotlinx.android.synthetic.main.news_or_movies.*
import java.util.*


class NewsFragment:Fragment() {
    private val dataItems: List<News> = ArrayList()

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

        val layoutManager= LinearLayoutManager(context)
        layoutManager.orientation=LinearLayoutManager.VERTICAL    //垂直排列
        itemsRecyclerView.layoutManager=layoutManager
        //itemsRecyclerView.adapter=NewsAdapter(dataItems)
        itemsRecyclerView.adapter=NewsAdapter(getNews())
    }

    private fun getNews():List<News>{
        val newsList=ArrayList<News>()
        for(i in 1..10){
            val news=News()
            news.setUrl("https://blog.csdn.net/yaoyaoyao_123/article/details/85205594")
            news.setTitle("This is title $i")
            news.setAuthorName("This is Author $i")
            news.setDate("This is Date $i")
            news.setThumbnailPicS(1,"http://n.sinaimg.cn/default/1_img/upload/3933d981/27/w930h697/20201206/ba38-keyancw4531896.jpg")
            newsList.add(news)
        }
        return newsList
    }
}