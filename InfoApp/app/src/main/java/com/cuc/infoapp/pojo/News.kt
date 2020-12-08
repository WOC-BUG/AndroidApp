package com.cuc.infoapp.pojo
import java.io.Serializable
// Serializable能够序列化对象
// 参考文档：https://blog.csdn.net/weixin_37418246/article/details/80739882
class News:Serializable {
    private lateinit var uniqueKey:String   //唯一标识码
    private lateinit var title:String   //标题
    private lateinit var date:String    //发布日期
    private lateinit var category:String    //类型
    private lateinit var authorName:String //作者名
    private lateinit var url:String //网址
    private lateinit var thumbnailPicS:String //图片1
    private lateinit var thumbnailPicS02:String   //图片2
    private lateinit var thumbnailPicS03:String   //图片3

    // 变量赋值
    fun setUniqueKey(uniqueKey: String){
        this.uniqueKey=uniqueKey
    }
    fun setTitle(title: String) {
        this.title = title
    }
    fun setDate(date: String) {
        this.date = date
    }
    fun setCategory(category:String){
        this.category=category
    }
    fun setUrl(url: String) {
        this.url = url
    }
    fun setAuthorName(authorName:String){
        this.authorName=authorName
    }
    fun setThumbnailPicS(num:Int, thumbnailPicS:String){
        when (num) {
            1 -> this.thumbnailPicS=thumbnailPicS
            2 -> this.thumbnailPicS02=thumbnailPicS
            3 -> this.thumbnailPicS03=thumbnailPicS
        }
    }

    //  获取数据
    fun getUniqueKey():String {
        return this.uniqueKey
    }
    fun getTitle():String {
        return this.title
    }
    fun getDate():String {
        return this.date
    }
    fun getCategory():String{
        return this.category
    }
    fun getUrl():String{
        return this.url
    }
    fun getAuthorName():String{
        return this.authorName
    }
    fun getThumbnailPicS(num:Int):String{
        return when (num) {
            1 -> this.thumbnailPicS
            2 -> this.thumbnailPicS02
            else -> this.thumbnailPicS03
        }
    }
}