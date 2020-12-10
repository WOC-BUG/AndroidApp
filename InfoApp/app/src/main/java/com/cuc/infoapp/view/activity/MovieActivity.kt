package com.cuc.infoapp.view.activity

import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Comment
import com.cuc.infoapp.pojo.Movie
import com.cuc.infoapp.view.adapter.CommentAdapter
import com.cuc.infoapp.view.adapter.PerformerAdapter
import kotlinx.android.synthetic.main.movie_basic_information.*
import kotlinx.android.synthetic.main.movie_content.*

class MovieActivity : AppCompatActivity() , View.OnClickListener{

    //private var movie: Movie = Movie()
    private lateinit var movie: Movie
    private lateinit var actorList: List<String>    //演员列表
    private var commentList = ArrayList<Comment>()  //评论列表

    //初始化
    private fun getMovieInfo() {

        val genres:String = movie.genres
        val language:String = movie.language
        val release_date:String = movie.release_date.toString()
        val runtime: String = movie.runtime
        var country:String = movie.country

        //基本信息
        Glide.with(this).load(movie.poster).error(R.drawable.movie1).into(moviePoster);
        movieTitle.setText(movie.title)
        movieType.setText("$genres/$language")
        val info = "$runtime/$release_date${country}上映"
        movieInfo.setText(info)
        if(movie.rating != null)
            movieScore.setText("${movie.rating}(${movie.rating_count}人评)")
        else
            movieScore.setText("暂无评分")
        if(movie.plot_simple != null)
            movieIntroduction.setText(movie.plot_simple)
        else
            movieIntroduction.setText("影片简介暂无^_^")
        //演员列表
        actorList = movie.actors.split(',')
        //评论
        this.initComments()
    }


    private var actorAdapter : PerformerAdapter ?= null
    private var commentAdapter : CommentAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_content)

        movie = intent.getSerializableExtra("movieItem") as Movie  //获取传递过来的Movie对象
        //Log.d("MainActivity",movie.getPoster().toString())

        Glide.with(moviePoster.context).load(movie.poster).error(R.drawable.movie1).into(moviePoster);

        //通过获得的Movie对象初始化需展示的电影信息
        this.getMovieInfo()

        val layoutManager1 = LinearLayoutManager(this)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL  //横向展示items
        performerRecyclerView.layoutManager = layoutManager1
        actorAdapter = PerformerAdapter(actorList)
        performerRecyclerView.adapter = actorAdapter

        val layoutManager2 = LinearLayoutManager(this)
        commentRecyclerView.layoutManager = layoutManager2
        layoutManager2.orientation= LinearLayoutManager.VERTICAL     //纵向展示items
        commentAdapter = CommentAdapter(commentList)
        commentRecyclerView.adapter = commentAdapter
        accept_comment.setOnClickListener(this)
    }

    //初始化演员数组
//    private fun initActors(){
//        //从网络获取数据
//
//        //test
//        for(i in 1..10){
//            actorList.add("actor $i")
//        }
//    }
    //初始化评论数组
    private fun initComments() {

        //自定义
        commentList.add(Comment("Cindy", R.drawable.user1, "The plot was really good!"))
        commentList.add(Comment("John", R.drawable.user2, "perfect and facinating!"))
        commentList.add(Comment("Charles", R.drawable.user3, "I like it!"))

    }

    //评论 点击事件
    override fun onClick(v: View?) {
        when (v) {
            accept_comment -> {
                val content = comment_box.text.toString()
                if(content.isNotEmpty()){

                    val cmn = Comment(getRandomName(),getRandomImg(),content)
                    commentList.add(cmn)
                    //当有新评论，刷新RecyclerView中的显示
                    commentAdapter?.notifyItemInserted(commentList.size-1)
                    //将RecyclerView定位到最后一行
                    commentRecyclerView.scrollToPosition(commentList.size-1)
                    comment_box.setText("")  //清空输入框
                }
            }
        }
    }
    //产生随机字符串
    private fun getRandomName():String{
        var uName : String = ""
        val list = mutableListOf<String>("dshXA01","hjdk_9","kid03","abc8","gds008","hser_3","Quhr111")
        list.shuffled().take(1).forEach{
            uName = it.toString()
        }
        return uName
    }
    //随机获取头像
    private fun getRandomImg():Int{
        val arrayOfImg: IntArray = intArrayOf(R.drawable.user1,R.drawable.user2,R.drawable.user3,R.drawable.user4,R.drawable.user5)
        val i = (0..4).random()
        return arrayOfImg[i]
    }

}