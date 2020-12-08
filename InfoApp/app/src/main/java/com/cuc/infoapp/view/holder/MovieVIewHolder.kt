package com.cuc.infoapp.view.holder

import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R

class MovieVIewHolder(view: View): RecyclerView.ViewHolder(view) {
    val movieItem: FrameLayout = view.findViewById(R.id.moviesItemLayout)
}