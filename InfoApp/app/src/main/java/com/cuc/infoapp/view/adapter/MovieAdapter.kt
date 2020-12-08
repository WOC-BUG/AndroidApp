package com.cuc.infoapp.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Movie
import com.cuc.infoapp.view.activity.MovieActivity
import com.cuc.infoapp.view.holder.MovieVIewHolder
import kotlinx.android.synthetic.main.item_movies.view.*

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieVIewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVIewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_movies,parent,false)
        return MovieVIewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieVIewHolder, position: Int) {
        val movie=movieList[position]
        holder.movieItem.moviesTitle.text=movie.getTitle()
        /*
        图片加载方法：
        https://blog.csdn.net/weixin_43396054/article/details/108992191
        https://blog.csdn.net/chennai1101/article/details/103985572
         */
        Glide.with(holder.itemView.context).load(movie.getPoster()).error(R.drawable.movie1).into(holder.movieItem.moviesImage);

        //配置监听器
        holder.movieItem.setOnClickListener(OnClickListener(movie))
    }

    override fun getItemCount(): Int = movieList.size

    private class OnClickListener(var movie: Movie) : View.OnClickListener {
        override fun onClick(p0: View) {
            val intent = Intent(p0.context,MovieActivity::class.java)
            intent.putExtra("movieItem",movie)
            p0.context.startActivity(intent)
        }
    }
}