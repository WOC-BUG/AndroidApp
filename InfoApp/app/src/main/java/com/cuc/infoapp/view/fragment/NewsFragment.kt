package com.cuc.infoapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.*
import com.cuc.infoapp.pojo.News
import com.cuc.infoapp.pojo.NewsResponse
import com.cuc.infoapp.view.adapter.NewsAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.news_or_movies.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.collections.ArrayList
import kotlin.concurrent.thread


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
        sendRequest()
    }

    private fun showResponse(response: String) {
        //println(response)
        val gson = Gson()
        val person: NewsResponse =gson.fromJson(response,
            NewsResponse::class.java)
        itemsRecyclerView.adapter=NewsAdapter(person.result.data)
    }

    private fun sendRequest(){
        thread{
            var connection: HttpURLConnection? = null
            try{
                val response = StringBuilder()
                val url= URL(Api().getNews)
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