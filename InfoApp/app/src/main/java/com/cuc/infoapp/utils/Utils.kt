package com.cuc.test

import android.content.Context
import android.location.Location
import androidx.appcompat.app.AlertDialog
import com.cuc.infoapp.utils.AddressInfo
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.net.URLConnection

/**
 * 辅助工具类
 */
object Utils {

    /**
     * 通过经纬度获取地址信息
     */
    fun getAddressInfo(location: Location): AddressInfo? {

        val latitude = location.latitude
        val longitude = location.longitude
        var addressInfo: AddressInfo? = null

        //http://api.map.baidu.com/reverse_geocoding/v3/?ak=BzVZdc7KsVHT3XSdnfg1hafhtIRKfO5q&mcode=BE:68:DF:FE:44:DF:C2:46:03:1C:82:27:AF:B0:B2:75:9F:D8:85:1E;com.cuc.infoapp&location=116.40387397,39.91488908&dataType=json
        val baiduAk = "xZaQoG0PG1HdsBj3ver34zD5MzEFy4ck"
        val Sha1="BE:68:DF:FE:44:DF:C2:46:03:1C:82:27:AF:B0:B2:75:9F:D8:85:1E"
        val packageName="com.cuc.infoapp"

        val url="http://api.map.baidu.com/reverse_geocoding/v3/?ak=$baiduAk&mcode=$Sha1;$packageName&output=json&coordtype=wgs84ll&location=$latitude,$longitude&dataType=json"
        var myURL: URL?
        var httpsConn: URLConnection?
        try {
            myURL = URL(url)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            return null
        }

        try {
            httpsConn = myURL.openConnection()

            if (httpsConn != null) {
                val inputStreamReader = InputStreamReader(httpsConn.getInputStream(), "UTF-8")
                val br = BufferedReader(inputStreamReader)
                val data: String? = br.readLine()
                if (data != null) {
                    addressInfo = Gson().fromJson(data, AddressInfo::class.java)
                }
                inputStreamReader.close()
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }

        return addressInfo
    }

    fun showAlert(message: String, context: Context) {
        val alertDialog = AlertDialog.Builder(context).setMessage(message).setCancelable(false)
            .setPositiveButton(android.R.string.ok)
            { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton(android.R.string.cancel) { dialog, _ -> dialog.dismiss() }
            .create()
        alertDialog.show()
    }

}