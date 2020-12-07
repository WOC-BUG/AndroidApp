package com.cuc.infoapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Movie

class MovieAdapter(val movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val MovieImage: ImageView = view.findViewById(R.id.moviePoster)
        val MovieTitle : TextView =view.findViewById(R.id.movieTitle)
        val MovieType : TextView =view.findViewById(R.id.movieType)
        val MovieInfo : TextView =view.findViewById(R.id.movieInfo)
        val MovieScore : TextView =view.findViewById(R.id.movieScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.home_main,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = movieList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val MoviePosition = movieList[position]
        //holder.MovieImage.setImageResource(MoviePosition.poster)//这里需要int,但是poster是string
        val Imagesrc: String = MoviePosition.getCover()
        holder.MovieTitle.setText(MoviePosition.getTitle())
        holder.MovieInfo.setText(MoviePosition.getCountry())
        holder.MovieInfo.setText(MoviePosition.getActors())
        holder.MovieInfo.setText(MoviePosition.getLanguage())
        holder.MovieScore.setText(MoviePosition.getRating())
        holder.MovieType.setText(MoviePosition.getType())

    }

}

private fun TextView.setText(country: String, actors: String, language: String) {

}//这是为了传很多准备的


