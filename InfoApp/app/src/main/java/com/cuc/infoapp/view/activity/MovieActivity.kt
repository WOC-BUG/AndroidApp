package com.cuc.infoapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Comment
import com.cuc.infoapp.view.adapter.CommentAdapter
import com.cuc.infoapp.view.adapter.PerformerAdapter
import kotlinx.android.synthetic.main.chattingrobot_main.*
import kotlinx.android.synthetic.main.movie_content.*

class MovieActivity : AppCompatActivity() , View.OnClickListener{

    private val actorList = ArrayList<String>()    //演员列表
    private val commentList = ArrayList<Comment>()  //评论列表

    private var actorAdapter : PerformerAdapter ?= null
    private var commentAdapter : CommentAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_content)

        this.initActors()
        val layoutManager1 = LinearLayoutManager(this)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL  //横向展示items
        performerRecyclerView.layoutManager = layoutManager1
        actorAdapter = PerformerAdapter(actorList)
        performerRecyclerView.adapter = actorAdapter

        this.initComments()
        val layoutManager2 = LinearLayoutManager(this)
        commentRecyclerView.layoutManager = layoutManager2
        layoutManager2.orientation= LinearLayoutManager.VERTICAL     //纵向展示items
        commentAdapter = CommentAdapter(commentList)
        commentRecyclerView.adapter = commentAdapter
        accept_comment.setOnClickListener(this)
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

    override fun onClick(v: View?) {
        when (v) {
            accept_comment -> {
                val content = comment_box.text.toString()
                if(content.isNotEmpty()){
                    val i = (1..3).random()
                    val cmn = Comment(getRandomName(),R.drawable.user2,content)
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
        val list = mutableListOf<String>("dshXA01","hjdk_9","kid03","abc8","gds008","hser_3")
        list.shuffled().take(1).forEach{
            uName = it.toString()
        }
        return uName
    }

}