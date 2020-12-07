package com.cuc.infoapp.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.cuc.infoapp.R
import com.github.clans.fab.FloatingActionButton
import kotlinx.android.synthetic.main.item_news.*


class FloatButton : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.home_main)
        var buttonrobot: ImageView = view.findViewById(R.id.ButtonRobot)
    }
//    floatingActionButton.setOnClickListener(new View.OnClickListener() {
//        public void onClick(View:view) {
//            //TODO
//
//        }
//    })
//}
}