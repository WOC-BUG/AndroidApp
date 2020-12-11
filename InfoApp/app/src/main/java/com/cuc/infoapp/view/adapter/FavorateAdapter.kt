package com.cuc.infoapp.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Movie
//import com.cuc.infoapp.service.News
import com.cuc.infoapp.view.activity.NewsActivity
import com.cuc.infoapp.view.holder.FavoriteViewHolder
import kotlinx.android.synthetic.main.movie_basic_information.*
import kotlinx.android.synthetic.main.movie_basic_information.view.*

class FavorateAdapter(private var movieList: List<Movie>) : RecyclerView.Adapter<FavoriteViewHolder>(){

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
        Glide.with(holder.itemView.context).load(movie.poster).error(R.drawable.movie1).into(holder.favoriteItem.moviePoster);
        holder.favoriteItem.movieTitle.setText(movie.title)
        holder.favoriteItem.movieType.setText("${movie.genres}/${movie.language}")
        if(movie.rating != null)
            holder.favoriteItem.movieScore.setText("${movie.rating}(${movie.rating_count}人评)")
        else
            holder.favoriteItem.movieScore.setText("暂无评分")
        if(movie.runtime != null)
            holder.favoriteItem.movieInfo.setText("${movie.runtime}/${movie.release_date}${movie.country}上映")
        else
            holder.favoriteItem.movieInfo.setText("时长:暂无/${movie.release_date}于${movie.country}上映")

    }

    override fun getItemCount(): Int = movieList.size

    //更新适配器数据
    fun notifyDataChange(movieList: List<Movie>){
        this.movieList = movieList
        notifyDataSetChanged()
    }

}