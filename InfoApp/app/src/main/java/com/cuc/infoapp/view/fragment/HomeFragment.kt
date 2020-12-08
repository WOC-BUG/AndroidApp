package com.cuc.infoapp.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Movie
import com.cuc.infoapp.pojo.News
import com.cuc.infoapp.view.activity.ChatActivity
import com.cuc.infoapp.view.activity.NewsActivity
import com.cuc.infoapp.view.adapter.FavorateAdapter
import com.cuc.infoapp.view.adapter.NewsAdapter
import kotlinx.android.synthetic.main.home_main.*
import java.util.*


class HomeFragment: Fragment() {
    private val movieList: ArrayList<Movie> = ArrayList()
   // private lateinit var robotbutton: Robotbutton
    // 创建Fragment的布局
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.home_main, null, false)

       val robotButton=view.findViewById<ImageView>(R.id.button_robot)
//监听器配置
       robotButton.setOnClickListener (Jump())
       return view

    }

    class Jump:View.OnClickListener {
        override fun onClick(v: View) {
            val intent = Intent(v.context, ChatActivity::class.java)
            v.context.startActivity(intent)
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //initMovies()

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL    //垂直排列
        favorate_movie.layoutManager = layoutManager
        //itemsRecyclerView.adapter=NewsAdapter(dataItems)
        favorate_movie.adapter = FavorateAdapter(initMovies())

    }

    private fun initMovies():List<Movie> {//这里是要传回的数据们
        val movie=Movie()
        movie.setTitle("哈利波特")
        movie.setLanguage("English")
        movie.setactors("Harry Potter")
        movie.setCountry("English")
        movie.setRating("1")
        movie.setType("1")
        movieList.add(movie)
        return movieList
    }

}




