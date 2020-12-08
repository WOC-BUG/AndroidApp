package com.cuc.infoapp.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Msg
import com.cuc.infoapp.view.fragment.HomeFragment
import com.github.clans.fab.FloatingActionButton
import kotlinx.android.synthetic.main.item_news.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.home_main)

        val buttonrobot:FloatingActionButton=findViewById(R.id.button_robot)
        buttonrobot.setOnClickListener(OnClickListener())
    }

    class OnClickListener() : View.OnClickListener {
        override fun onClick(v: View) {
            val intent = Intent(v.context,ChatActivity::class.java)
            v.context.startActivity(intent)
        }
    }

}