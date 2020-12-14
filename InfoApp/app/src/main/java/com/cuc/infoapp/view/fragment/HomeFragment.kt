package com.cuc.infoapp.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Movie
import com.cuc.infoapp.view.activity.ChatActivity
import com.cuc.infoapp.view.activity.MovieActivity
import com.cuc.infoapp.view.adapter.FavorateAdapter
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
        favorate_movie.adapter = FavorateAdapter(initMovies())

    }

    private fun initMovies():List<Movie> {//这里是要传回的数据们

        val moviedemo=Movie("2"," 克里斯汀·贝尔,伊迪娜·门泽尔,乔纳森·格罗夫,乔什·加德,圣蒂诺·方塔纳","冰雪皇后","美国", " 克里斯·巴克",
            "America","喜剧/动画/奇幻","英语","hhjfhdasjhf","https://tu.tianzuida.com/pic/upload/vod/2019-11-22/201911221574404114.jpg",
            "8.4","559966",2014,"102 min", "冰雪奇缘", "null","珍妮弗·李",2013)

        movieList.add(moviedemo)

        var bundle: Bundle? = this.arguments
        if(bundle != null){
            //println("来自MovieActivity的数据")
            var movie:Movie = bundle.getSerializable("favourItem") as Movie
            movieList.add(movie)
        }
        println(movieList)

       // favorate_movie.adapter?.notifyDataSetChanged()
        return movieList
    }

}




