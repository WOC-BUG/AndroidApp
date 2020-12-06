package com.cuc.infoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Movie


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_main, container, false)
    }

}
class MovieAdapter(val movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val MovieImage: ImageView = view.findViewById(R.id.moviePoster)
        val MovieTitle :TextView=view.findViewById(R.id.movieTitle)
        val MovieType :TextView=view.findViewById(R.id.movieType)
        val MovieInfo :TextView=view.findViewById(R.id.movieInfo)
        val MovieScore :TextView=view.findViewById(R.id.movieScore)
        val checkStar:AppCompatCheckBox=view.findViewById(R.id.checkStar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}