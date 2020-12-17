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
import com.cuc.infoapp.pojo.*
import com.cuc.infoapp.pojo.News
import com.cuc.infoapp.pojo.NewsResponse
import com.cuc.infoapp.service.SendRequest
import com.cuc.infoapp.view.adapter.NewsAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.news_or_movies.*
import kotlin.collections.ArrayList


class NewsFragment:Fragment() {
    private val dataItems: List<News> = ArrayList()

    // 创建Fragment的布局
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        return inflater.inflate(R.layout.news_or_movies, null, false)
    }

    //  当Activity完成onCreate()时调用
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutManager= LinearLayoutManager(context)
        layoutManager.orientation=LinearLayoutManager.VERTICAL    //垂直排列
        itemsRecyclerView.layoutManager=layoutManager
        //发送请求获取数据
        SendRequest().sendRequest(Api().getNews,handler)
    }

    // 更新UI
    private val handler= @SuppressLint("HandlerLeak")
    object :Handler(){
        override fun handleMessage(msg: Message) {
            val gson = Gson()
            val news: NewsResponse =gson.fromJson(msg.data.getString("data"),NewsResponse::class.java)
            if(news.result!=null)
            {
                when(msg.what){
                    1-> itemsRecyclerView.adapter=NewsAdapter(news.result.data)
            }
        }
        }
    }
}