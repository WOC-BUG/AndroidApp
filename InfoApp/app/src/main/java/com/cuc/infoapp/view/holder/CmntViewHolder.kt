package com.cuc.infoapp.view.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R

class CmntViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val userName : TextView = view.findViewById(R.id.textView)
    val userImage : ImageView = view.findViewById(R.id.imageView)
    val comments : TextView = view.findViewById(R.id.comments)
}