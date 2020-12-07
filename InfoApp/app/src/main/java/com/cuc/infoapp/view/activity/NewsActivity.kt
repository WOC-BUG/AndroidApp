package com.cuc.infoapp.view.activity

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.News
import kotlinx.android.synthetic.main.news_content.*

class NewsActivity(private val new:News) : AppCompatActivity() {

    lateinit var url:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_content)

        url=new.getUrl()
        webView.settings.javaScriptEnabled=true
        webView.webViewClient= WebViewClient()
        webView.loadUrl(url)
    }
}