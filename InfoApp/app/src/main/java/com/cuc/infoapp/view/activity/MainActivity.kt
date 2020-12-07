package com.cuc.infoapp.view.activity

import FragmentAdapter
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cuc.infoapp.R
import com.cuc.infoapp.view.fragment.NewsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
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

        //初始化控件
        bottomNavigationView=findViewById(R.id.bottomNavigationView)
        viewPager=findViewById(R.id.viewPager)
        listFragment.add(NewsFragment())    //添加新闻Fragment

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
                if (menuItem != null) {
                    //如果有已选中的item，则取消它的的选中状态
                    menuItem.isChecked = false;
                } else {
                    //如果没有，则取消默认的选中状态（第一个item）
                    bottomNavigationView.menu.getItem(0).isChecked = false;
                }
                //让与当前Pager相应的item变为选中状态
                menuItem = bottomNavigationView.menu.getItem(position);
                menuItem.isChecked = true;
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