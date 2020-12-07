package com.cuc.infoapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R
import kotlinx.android.synthetic.main.performer_item.*

//演员列表适配器
class PerformerAdapter(val actorList: List<String>): RecyclerView.Adapter<PerformerAdapter.ViewHolder>() {

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val actorName : TextView = view.findViewById(R.id.performerName)
    }

    //创建ViewHolder实例 ，加载布局
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.performer_item,parent,false)
        return ViewHolder(view)
    }

    //对布局控件赋值
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actor = actorList[position]
        holder.actorName.setText(actor)
    }

    override fun getItemCount(): Int {
        return actorList.size
    }
}