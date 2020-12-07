package com.cuc.infoapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Comment
import com.cuc.infoapp.view.adapter.CommentAdapter
import com.cuc.infoapp.view.adapter.PerformerAdapter
import kotlinx.android.synthetic.main.movie_content.*

class MovieActivity : AppCompatActivity() {

    private val actorList = ArrayList<String>()    //演员列表
    private val commentList = ArrayList<Comment>()  //评论列表

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_content)

        this.initActors()
        val layoutManager1 = LinearLayoutManager(this)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL  //横向展示items
        performerRecyclerView.layoutManager = layoutManager1
        val actorAdapter = PerformerAdapter(actorList)
        performerRecyclerView.adapter = actorAdapter

        this.initComments()
        val layoutManager2 = LinearLayoutManager(this)
        commentRecyclerView.layoutManager = layoutManager2
        layoutManager2.orientation= LinearLayoutManager.VERTICAL     //纵向展示items
        val commentAdapter = CommentAdapter(commentList)
        commentRecyclerView.adapter = commentAdapter
    }

    //初始化演员数组
    private fun initActors(){
        //从网络获取数据

        //test
        for(i in 1..10){
            actorList.add("actor $i")
        }
    }
    //初始化评论数组
    private fun initComments() {

        //自定义
        commentList.add(Comment("Cindy", R.drawable.user1, "The plot was really good!"))
        commentList.add(Comment("John", R.drawable.user2, "perfect and facinating!"))
        commentList.add(Comment("Charles", R.drawable.user3, "I like it!"))

    }
}