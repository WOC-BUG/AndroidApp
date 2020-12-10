package com.cuc.infoapp.pojo

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    var reason: String,
    var result: Result
)

data class Result(
    var data: List<News>,
    var stat: String
)

data class News(
    var author_name: String,
    var category: String,
    var date: String,
    var thumbnail_pic_s: String,
    var thumbnail_pic_s02: String,
    var thumbnail_pic_s03: String,
    var title: String,
    var uniquekey: String,
    var url: String
)