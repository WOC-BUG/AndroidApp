package com.cuc.infoapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Comment
import com.cuc.infoapp.view.holder.CmntViewHolder

// 电影评论区适配器
class CommentAdapter(private val commentList: List<Comment>): RecyclerView.Adapter<CmntViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CmntViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item,parent,false)
        return CmntViewHolder(view)
    }

    override fun onBindViewHolder(holder: CmntViewHolder, position: Int) {
        val comment = commentList[position]
        holder.userName.setText(comment.userName)
        holder.userImage.setImageResource(comment.userImageId)
        holder.comments.setText(comment.commentStr)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}