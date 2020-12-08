package com.cuc.infoapp.view.activity

import FragmentAdapter
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cuc.infoapp.R
import com.cuc.infoapp.view.fragment.HomeFragment
import com.cuc.infoapp.view.fragment.MovieFragment
import com.cuc.infoapp.view.fragment.NewsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.item_news.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView:BottomNavigationView //底部导航栏
    private lateinit var viewPager:ViewPager //中间切换页面
    private lateinit var menuItem:MenuItem  //选中的按钮
    //四个页面
    private var listFragment : ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // setContentView(R.layout.movie_content)
        //listFragment.add(MovieContentFragment())    //添加电影详情Fragment

        //初始化控件
        bottomNavigationView=findViewById(R.id.bottomNvigationView)
        viewPager=findViewById(R.id.viewPager)
        listFragment.add(NewsFragment())    //添加新闻Fragment
        listFragment.add(MovieFragment())    //添加视频Fragment
        listFragment.add(HomeFragment())    //添加HomeFragment

        /* 未实现
        //电影海报点击监听事件
        val movieItem : FrameLayout = findViewById(R.id.moviesItemLayout)
        movieItem.setOnClickListener {
            fun onClick(){
                val intent = Intent( this, MovieActivity::class.java)
                startActivity(intent)
            }
        }*/

        //默认选中第一个页面
        bottomNavigationView.menu.getItem(0).isChecked = true;

        //设置监听器
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationSelectedListener)
        viewPager.setOnPageChangeListener(viewPagerListener)

        //设置页面适配器
        viewPager.adapter=FragmentAdapter(supportFragmentManager,listFragment)
        viewPager.offscreenPageLimit = 4
    }


    /*
    教程：
    https://www.jianshu.com/p/5993e8037d4d
    https://blog.csdn.net/lllx9464/article/details/79384076
     */

    //设置viewPager页面切换事件
    private val viewPagerListener: ViewPager.OnPageChangeListener =
        object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                //让与当前Pager相应的item变为选中状态
                menuItem = bottomNavigationView.menu.getItem(position);
            }
        }

    //设置底部导航栏菜单项Item选中监听
    private val bottomNavigationSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navigation_news -> {
                        viewPager.currentItem = 0
                        return true
                    }
                    R.id.navigation_movie -> {
                        viewPager.currentItem = 1
                        return true
                    }
                    R.id.navigation_weather -> {
                        viewPager.currentItem = 2
                        return true
                    }
                    R.id.navigation_home -> {
                        viewPager.currentItem = 3
                        return true
                    }
                }
                return false
            }
        }
}