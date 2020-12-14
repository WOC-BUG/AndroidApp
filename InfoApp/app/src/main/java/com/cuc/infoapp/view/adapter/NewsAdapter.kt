package com.cuc.infoapp.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.News
import com.cuc.infoapp.view.activity.NewsActivity
import com.cuc.infoapp.view.holder.NewsViewHolder
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private var newsList: List<News>) : RecyclerView.Adapter<NewsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news=newsList[position]
        holder.newsItem.newsTitle.text=news.title
        holder.newsItem.newsAuthor.text=news.author_name
        holder.newsItem.newsDate.text=news.date
        /*
        图片加载方法：
        https://blog.csdn.net/weixin_43396054/article/details/108992191
        https://blog.csdn.net/chennai1101/article/details/103985572
         */
        Glide.with(holder.itemView.context).load(news.thumbnail_pic_s).error(R.drawable.person1).into(holder.newsItem.newsImage);

        // 配置监听器
        holder.newsItem.setOnClickListener(OnClickListener(news))
    }

    override fun getItemCount(): Int = newsList.size

    private class OnClickListener(var news: News) : View.OnClickListener {
        override fun onClick(v: View) {
            val intent = Intent(v.context, NewsActivity::class.java)
            intent.putExtra("url", news.url)
            v.context.startActivity(intent)
        }
    }
}