package com.cuc.infoapp.view.activity

import FragmentAdapter
import android.R.attr.fragment
import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.MenuItem
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.afollestad.assent.Permission
import com.afollestad.assent.runWithPermissions
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Api
import com.cuc.infoapp.view.fragment.HomeFragment
import com.cuc.infoapp.view.fragment.MovieFragment
import com.cuc.infoapp.view.fragment.NewsFragment
import com.cuc.infoapp.view.fragment.WeatherFragment
import com.cuc.test.Callback
import com.cuc.test.LocationUtils
import com.cuc.test.Utils
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*


class MainActivity : AppCompatActivity() {
    val fragmentManager: FragmentManager = supportFragmentManager
    val fragmentTransaction: FragmentTransaction =
        fragmentManager.beginTransaction()
    private lateinit var bottomNavigationView:BottomNavigationView //底部导航栏
    private lateinit var viewPager:ViewPager //中间切换页面
    private lateinit var menuItem:MenuItem  //选中的按钮
    var api:Api=Api()
    var weatherFragment=WeatherFragment(api)
    //四个页面
    private var listFragment : ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化控件
        bottomNavigationView=findViewById(R.id.bottomNavigationView)
        viewPager=findViewById(R.id.viewPager)
        listFragment.add(NewsFragment())    //添加新闻Fragment
        listFragment.add(MovieFragment())    //添加视频Fragment
        listFragment.add(weatherFragment)    //添加天气Fragment
        listFragment.add(HomeFragment())    //添加HomeFragment

        //默认选中第一个页面
        bottomNavigationView.menu.getItem(0).isChecked = true;


        //设置监听器
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationSelectedListener)
        viewPager.setOnPageChangeListener(viewPagerListener)

        //设置页面适配器
        viewPager.adapter=FragmentAdapter(supportFragmentManager,listFragment)
        viewPager.offscreenPageLimit = 4
        //定位
        locate()
    }


    /*
    页面切换教程：
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


    // GPS定位
    // 更新UI
    private val handler= @SuppressLint("HandlerLeak")
    object :Handler(){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                1-> {
                    api.cityName= msg.data.getString("cityName").toString()
                    locationTv.text=api.cityName
                }
            }
        }
    }

    // 源码：  https://blog.csdn.net/yinxing2008/article/details/85695163
    // 博客代码不全，去他的gitee里看
    private fun locate() {
        runWithPermissions(Permission.ACCESS_FINE_LOCATION) {
            if (LocationUtils.isLocationProviderEnabled(this@MainActivity)) {
                progressBar.visibility = View.VISIBLE
                showLocationWithToast()
            } else {
                Utils.showAlert("本应用需要获取地理位置，请打开获取位置的开关", this)
            }
        }
    }

    private fun showLocationWithToast() {
        LocationUtils.getLocation(this@MainActivity, object : Callback {
            override fun onLocationChanged(location: Location) {
                onGetLocation(location)
            }
        })
    }

    @SuppressLint("SetTextI18n", "ResourceType")
    private fun onGetLocation(location: Location) {
        GlobalScope.launch(Dispatchers.IO) {
            val locationResult = Utils.getAddressInfo(location)
            println(locationResult)
            launch(Dispatchers.Main) {
                locationResult?.let {
                    //通过handler发送message传参，在主线程更新UI、在WeatherFragment传递城市名
                    val bundle=Bundle()
                    bundle.putString("cityName",locationResult.result.addressComponent.city)
//                    //给天气页面更新数据
//                    weatherFragment.arguments=bundle
                    //给主页面UI传参
                    val msg=Message()
                    msg.what=1
                    msg.data=bundle
                    handler.sendMessage(msg)
                    progressBar.visibility = View.GONE
                }
            }
        }
    }
}