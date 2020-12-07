package com.cuc.infoapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Comment

// 电影评论区适配器
class CommentAdapter(val commentList: List<Comment>): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val userName : TextView = view.findViewById(R.id.textView)
        val userImage : ImageView = view.findViewById(R.id.imageView)
        val comments : TextView = view.findViewById(R.id.comments)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = commentList[position]
        holder.userName.setText(comment.userName)
        holder.userImage.setImageResource(comment.userImageId)
        holder.comments.setText(comment.commentStr)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}