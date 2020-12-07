package com.cuc.infoapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.News
import com.cuc.infoapp.view.holder.NewsViewHolder
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val newsList: List<News>) : RecyclerView.Adapter<NewsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news=newsList[position]
        holder.newsItem.newsTitle.text=news.getTitle()
        holder.newsItem.newsAuthor.text=news.getAuthorName()
        holder.newsItem.newsDate.text=news.getDate()
        /*
        图片加载方法：
        https://blog.csdn.net/weixin_43396054/article/details/108992191
        https://blog.csdn.net/chennai1101/article/details/103985572
         */
        Glide.with(holder.itemView.context).load(news.getThumbnailPicS(1)).error(R.drawable.person1).into(holder.newsItem.newsImage);
    }

    override fun getItemCount(): Int = newsList.size

}