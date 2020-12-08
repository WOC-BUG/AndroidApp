package com.cuc.infoapp.view.fragment

import FragmentAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Movie
import com.cuc.infoapp.pojo.MovieList
import com.cuc.infoapp.pojo.News
import com.cuc.infoapp.view.adapter.FavorateAdapter
import com.cuc.infoapp.view.adapter.MovieAdapter
import com.cuc.infoapp.view.adapter.NewsAdapter
import kotlinx.android.synthetic.main.chattingrobot_main.*
import kotlinx.android.synthetic.main.home_main.*
import kotlinx.android.synthetic.main.news_or_movies.*
import java.util.ArrayList


class HomeFragment : Fragment() {
    private val movieList: ArrayList<Movie> = ArrayList()

    // 创建Fragment的布局
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.home_main, null, false)
        return view
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //initMovies()

        val layoutManager= LinearLayoutManager(context)
        layoutManager.orientation=LinearLayoutManager.VERTICAL    //垂直排列
        favorate_movie.layoutManager=layoutManager
        //itemsRecyclerView.adapter=NewsAdapter(dataItems)
        favorate_movie.adapter= FavorateAdapter(movieList)

    }


//    private fun initMovies() {//这里是要传回的数据们
//        val movie=Movie()
//        movie.setTitle("哈利波特")
//        movie.setLanguage("English")
//        movie.setactors("Harry Potter")
//        movie.setCountry("English")
//        movie.setRating("1")
//        movie.setType("1")
//        movieList.add(movie)
//    }
}



//    private val movieList = ArrayList<Movie>()
//    //private lateinit var recyclerView: RecyclerView
//    override fun onCreateView(//为了返回视图
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        initMovies()
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.home_main, null, false)
//
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        val layoutManager =
//            LinearLayoutManager(context)//抄的大佬的，不知道对不对哦
//        layoutManager.orientation=LinearLayoutManager.VERTICAL
//        recycler_view.layoutManager = layoutManager
//        val adapter = MovieAdapter(movieList)
//        recycler_view.adapter = adapter
//    }
//
//    private fun initMovies() {//这里是要传回的数据们
//        val movie=Movie()
//        movie.setTitle("哈利波特")
//        movie.setLanguage("English")
//        movie.setactors("Harry Potter")
//        movie.setCountry("English")
//        movie.setRating("1")
//        movie.setType("1")
//        movieList.add(movie)
//    }


