package com.cuc.infoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Comment
import com.cuc.infoapp.view.adapter.CommentAdapter
import com.cuc.infoapp.view.adapter.PerformerAdapter
import kotlinx.android.synthetic.main.movie_content.*

class MovieContentFragment: Fragment() {

    private val actorList = ArrayList<String>()    //演员数组
    private val commentList = ArrayList<Comment>()  //评论数组


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_content, container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.initActors()
        val layoutManager1 = LinearLayoutManager(this.activity)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL  //横向展示items
        performerRecyclerView.layoutManager = layoutManager1
        val commentAdapter = CommentAdapter(commentList)
        performerRecyclerView.adapter = commentAdapter

        this.initComments()
        val layoutManager2 = LinearLayoutManager(this.activity)  //纵向展示items
        commentRecyclerView.layoutManager = layoutManager2
        val actorAdapter = PerformerAdapter(actorList)
        commentRecyclerView.adapter = actorAdapter
    }

    //初始化演员数组
    private fun initActors(){
        //从网络获取数据

    }
    //初始化评论数组
    private fun initComments(){

        //自定义
        commentList.add(Comment("Cindy", R.drawable.user1, "The plot was really good!"))
        commentList.add(Comment("John", R.drawable.user2, "perfect and facinating!"))
        commentList.add(Comment("Charles", R.drawable.user3, "I like it!"))


    }

}