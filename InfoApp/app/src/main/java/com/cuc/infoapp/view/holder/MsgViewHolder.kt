package com.cuc.infoapp.view.holder


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R

sealed class MsgViewHolder(view:View): RecyclerView.ViewHolder(view) {

    class LeftViewHolder(view: View):MsgViewHolder(view){//左边的视图容纳
    val leftMsg: TextView = view.findViewById(R.id.leftMsg)
    }

    class RightViewHolder(view: View):MsgViewHolder(view) {
        val rightMsg: TextView = view.findViewById(R.id.rightMsg)
    }
}