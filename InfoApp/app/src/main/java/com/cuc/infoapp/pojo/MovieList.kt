package com.cuc.infoapp.pojo

class MovieList {
    var movies:List<Movie>?=null

    fun getData(): List<Movie>? {
        return movies
    }

    fun setData(data: List<Movie>?) {//问号啥意思？在里在外有啥区别？
        this.movies = data
    }
}