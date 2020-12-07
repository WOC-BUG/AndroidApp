package com.cuc.infoapp.view.holder

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R

class NewsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val newsItem: ConstraintLayout = view.findViewById<ConstraintLayout>(R.id.newsItemLayout)
}