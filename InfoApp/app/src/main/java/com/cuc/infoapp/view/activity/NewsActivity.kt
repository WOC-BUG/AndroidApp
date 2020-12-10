package com.cuc.infoapp.view.activity

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.cuc.infoapp.R
import com.cuc.infoapp.service.News
import kotlinx.android.synthetic.main.news_content.*

class NewsActivity : AppCompatActivity() {
    private lateinit var new : News
    lateinit var url : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_content)

        url = intent.getSerializableExtra("url") as String   //获取传递过来的News对象
        webView.settings.javaScriptEnabled=true
        webView.webViewClient= WebViewClient()
        webView.loadUrl(url)
    }
}