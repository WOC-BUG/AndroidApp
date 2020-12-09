package com.cuc.infoapp.pojo

class Api {
    // 新闻接口
    private var newsUrl:String="http://v.juhe.cn/toutiao/index" //接口地址
    private var newsKey:String=""    //APPKEY

    //电影接口
    private var movieUrl:String="http://v.juhe.cn/movie/index" //接口地址
    private var moviekey:String="72c09f5cd7dddb597ccb1bff0bdab9a9"    //APPKEY
    private var movieTitle:String=""    //申请的电影标题
    private var movieMode:Int=0    //是否精确查找，精确1，模糊0
    private var cityId:Int=0    //城市ID

    //天气接口
    private var weatherUrl:String="http://v.juhe.cn/weather/uni" //接口地址
    private var weatherKey:String="06b240642fdae5d9a9a681f5762e8e29"    //APPKEY
    private var cityName:String="北京"    //APPKEY

}