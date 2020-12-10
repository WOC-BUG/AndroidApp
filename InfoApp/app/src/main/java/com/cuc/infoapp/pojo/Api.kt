package com.cuc.infoapp.pojo

class Api {
    // 新闻接口
    var newsUrl:String="http://v.juhe.cn/toutiao/index" //接口地址
    var newsKey:String="cd1eb457de10bf3b123ae3526a6bbd9d"    //APPKEY
    var getNews:String= "$newsUrl?key=$newsKey"

    //电影接口
    var movieUrl:String="http://v.juhe.cn/movie/index" //接口地址
    var moviekey:String="72c09f5cd7dddb597ccb1bff0bdab9a9"    //APPKEY
    var movieTitle:String=""    //申请的电影标题
    var movieMode:Int=0    //是否精确查找，精确1，模糊0
    var cityId:Int=0    //城市ID

    //天气接口
    var weatherUrl:String="http://v.juhe.cn/weather/uni" //接口地址
    var weatherKey:String="06b240642fdae5d9a9a681f5762e8e29"    //APPKEY
    var cityName:String="北京"    //城市

}