package com.cuc.infoapp.view.holder

import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.cuc.infoapp.R

class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val favoriteItem: LinearLayout =view.findViewById(R.id.movieBasicInfoLayout)
}
