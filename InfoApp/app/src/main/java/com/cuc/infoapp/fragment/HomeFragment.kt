package com.cuc.infoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Movie
import com.cuc.infoapp.view.adapter.MovieAdapter
import kotlinx.android.synthetic.main.chattingrobot_main.*


class HomeFragment : Fragment() {
    private val movieList = ArrayList<Movie>()
    override fun onCreateView(//为了返回视图
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_main, container, false)
        this.initMovies()
        val layoutManager =
            LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false)//抄的大佬的，不知道对不对哦
        recyclerView.layoutManager = layoutManager
        val adapter = MovieAdapter(movieList)
        recyclerView.adapter = adapter

    }

    private fun initMovies() {//这里是要传回的数据们
    }
}

