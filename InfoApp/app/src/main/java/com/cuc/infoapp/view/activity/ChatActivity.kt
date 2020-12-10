package com.cuc.infoapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuc.infoapp.R
import com.cuc.infoapp.pojo.Msg
import com.cuc.infoapp.service.Appservice
import com.example.chatinterface.MsgAdapter
import kotlinx.android.synthetic.main.chattingrobot_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChatActivity : AppCompatActivity(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()
    private var adapter : MsgAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chattingrobot_main)
        supportActionBar?.hide()

        initMsg()
        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        recycler_view.adapter=adapter//回收视图的适配器是本适配器
        send.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v) {
            send -> {
                val retrofit= Retrofit.Builder()
                    .baseUrl("https://api.qingyunke.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()//连接接口

                var msg:Msg=Msg("",0)
                val appService = retrofit.create(Appservice::class.java)
                appService.getMessageByGet("free",0,input_text.text.toString())
                    .enqueue(object : Callback<Msg> {
                        override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                            Log.d("Retrofit",response.body().toString())

                            msg= response.body()!!
//                            if(msg!=null){
//                                leftMsg.text=msg.content//发现报错很可能是布局文件的id出了问题
//                            }
                        }

                        override fun onFailure(call: Call<Msg>, t: Throwable) {
                            t.printStackTrace()
                        }
                    })
                val content =input_text.text.toString()
                if(content.isNotEmpty()){
                    val msg4 = Msg(content,Msg.TYPE_SENT)
                    msgList.add(msg4)//写入
                    adapter?.notifyItemInserted(msgList.size-1) //在末尾添加item
                    recycler_view.scrollToPosition(msgList.size-1)   //将下方的item移动到屏幕可见的最后一项
                    input_text.setText("")
                    val msg2=Msg(msg.toString(),Msg.TYPE_RECEIVED)
                    msgList.add(msg2)
                }
            }
        }
    }

    fun initMsg(){
        val msg3=Msg("What do you what to know?",Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}
