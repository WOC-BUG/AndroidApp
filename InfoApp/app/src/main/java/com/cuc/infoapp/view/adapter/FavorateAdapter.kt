package com.cuc.infoapp.view.adapter

import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Movie
import com.cuc.infoapp.pojo.News
import com.cuc.infoapp.view.activity.ChatActivity
import com.cuc.infoapp.view.activity.NewsActivity
import com.cuc.infoapp.view.holder.FavoriteViewHolder
import com.cuc.infoapp.view.holder.MovieVIewHolder
import kotlinx.android.synthetic.main.item_movies.view.*

class FavorateAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<FavoriteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.movie_basic_information,parent,false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val movie=movieList[position]
       // holder.favoriteItem.moviesTitle.text=movie.getTitle()
        /*
        图片加载方法：
        https://blog.csdn.net/weixin_43396054/article/details/108992191
        https://blog.csdn.net/chennai1101/article/details/103985572
         */
       // Glide.with(holder.itemView.context).load(movie.getPoster()).error(R.drawable.movie1).into(holder.favoriteItem.moviesImage);

    }



    override fun getItemCount(): Int = movieList.size

}