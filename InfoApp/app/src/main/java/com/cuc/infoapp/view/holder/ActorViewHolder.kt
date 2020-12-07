package com.cuc.infoapp.view.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R

class ActorViewHolder(view: View): RecyclerView.ViewHolder(view)   {
    val actorName : TextView = view.findViewById(R.id.performerName)
}