package com.cuc.infoapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Msg
import com.cuc.infoapp.view.holder.MsgViewHolder

class MsgAdapter(val msgList:List<Msg>): RecyclerView.Adapter<MsgViewHolder>(){//Adapter 就是视图的容纳器
override fun getItemViewType(position: Int): Int {
    val msg = msgList[position]
    return msg.type
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=if (viewType == Msg.TYPE_RECEIVED){//创建视图
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chattingrobot_left_item,parent,false)
        MsgViewHolder.LeftViewHolder(view)
    } else {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chattingrobot_right_item,parent,false)
        MsgViewHolder.RightViewHolder(view)//如果是接收就是left,否则是Right
    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when(holder){
            is MsgViewHolder.LeftViewHolder -> holder.leftMsg.text = msg.content
            is MsgViewHolder.RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }//将数据绑定在视图上

    override fun getItemCount() = msgList.size
}
