package com.cuc.infoapp.service

import com.cuc.infoapp.pojo.Movie

//获取Json转换成Bean类
class MovieBean( var error_code: Int, var resultcode: Int, var reason: String, var result :List<Movie>) {
    /* JSon数据格式：
        "resultcode": "200",
        "reason": "成功的返回",
        "result": [
        {
        "movieid": "137742",
        "rating": "-1",
        "genres": "动作/冒险/科幻",
        "runtime": "null",
        "language": "英语",
        "title": "哥斯拉",
        "poster": "http://v.juhe.cn/movie/img?55370",
        "writers": "麦克斯·鲍任斯坦,达夫·卡拉汉姆",
        "film_locations": "美国|日本",
        "directors": "加里斯·爱德华斯",
        "rating_count": "288",
        "actors": "亚伦·泰勒-约翰逊 Aaron Taylor-Johnson,布莱恩·科兰斯顿 Bryan Cranston,伊丽莎白·奥尔森 Elizabeth Olsen,渡边谦 Ken Watanabe",
        "plot_simple": "改编自1954年日本电影《哥斯拉》，围绕一位人类大兵的生活展开。讲述了沉睡的古代巨型怪兽被人们意外唤醒，醒来后的怪兽展现出强大的破坏能力，它的存在也震惊了世界。影片同时强调了原子弹对生物变异带来的直接影响。",
        "year": "2014",
        "country": "美国|日本",
        "type": "null",
        "release_date": "20140101",
        "also_known_as": ""
    }
    ],
        "error_code": 0
    */

}