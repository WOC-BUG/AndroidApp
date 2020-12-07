package com.cuc.infoapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import com.cuc.infoapp.view.holder.ActorViewHolder
import kotlinx.android.synthetic.main.performer_item.*

//演员列表适配器
class PerformerAdapter(private val actorList: List<String>): RecyclerView.Adapter<ActorViewHolder>() {

    /*
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val actorName : TextView = view.findViewById(R.id.performerName)
    }*/

    //创建ViewHolder实例 ，加载布局
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.performer_item,parent,false)
        return ActorViewHolder(view)
    }

    //对布局控件赋值
    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor = actorList[position]
        holder.actorName.setText(actor)
    }

    override fun getItemCount(): Int {
        return actorList.size
    }
}