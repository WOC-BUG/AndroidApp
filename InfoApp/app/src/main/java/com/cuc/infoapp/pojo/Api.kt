package com.cuc.infoapp.pojo

class Api {
    //百度地图接口
    var baiduUrl:String="http://api.map.baidu.com/reverse_geocoding/v3/"
    var baiduAK:String="uBE3iRti00quaSi1T36sznL0qvrKGmPo"
    var Sha1="BE:68:DF:FE:44:DF:C2:46:03:1C:82:27:AF:B0:B2:75:9F:D8:85:1E"
    var packageName="com.cuc.infoapp"

    // 新闻接口
    var newsUrl:String="http://v.juhe.cn/toutiao/index" //接口地址
    var newsKey:String="cd1eb457de10bf3b123ae3526a6bbd9d"    //APPKEY
    var getNews:String= "$newsUrl?key=$newsKey"

    //电影接口
    var movieUrl:String="http://v.juhe.cn/movie/index" //接口地址
    var moviekey:String="05bcbd2d51d9fb1ae9c2dae6761606e2"    //APPKEY
    //var movieTitle:String=getTitleKey()    //申请的电影标题
    var movieMode:Int=0    //是否精确查找，精确1，模糊0
    //var getMovies:String="$movieUrl?key=$moviekey&title=$movieTitle&smode=$movieMode"
    //var cityId:Int=0    //城市ID

    //天气接口
    var weatherUrl:String="http://apis.juhe.cn/simpleWeather/query" //接口地址
    var weatherKey:String="9a02045eeb3e12ca5094493bbe209028"    //APPKEY
    var cityName:String="北京"    //城市
    var getWeather:String = "$weatherUrl?city=$cityName&key=$weatherKey"
    //http://v.juhe.cn/weather/index?format=2&cityname=北京市&key=90fd9fc8d626f05f825f2e2f8ee5e12d
}