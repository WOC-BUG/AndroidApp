package com.cuc.test

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log


/**
 * @author jerry
 */
object LocationUtils {
    private val TAG = LocationUtils::class.java.simpleName

    /**
     * 获取地理位置，先根据GPS获取，再根据网络获取
     *
     * @return
     */
    @SuppressLint("MissingPermission")
    fun getLocation(context: Context, callback: Callback) {
        val locationListener: LocationListener = getLocationListener(callback)

        try {
            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {  //从gps获取经纬度
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)
            } else {//从网络获取经纬度
                getLocationByNetwork(context, callback)
            }

        } catch (e: Exception) {
            e.message?.let { Log.e(TAG, it) }
        }
    }

    private fun getLocationListener(callback: Callback): LocationListener {
        return object : LocationListener {

            // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {
                Log.d(TAG, "onStatusChanged")
            }

            // Provider被enable时触发此函数，比如GPS被打开
            override fun onProviderEnabled(provider: String) {
                Log.d(TAG, "onProviderEnabled")

            }

            // Provider被disable时触发此函数，比如GPS被关闭
            override fun onProviderDisabled(provider: String) {
                Log.d(TAG, "onProviderDisabled")

            }

            //当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
            override fun onLocationChanged(location: Location) {
                callback.onLocationChanged(location)
            }
        }
    }

    /**
     * 判断是否开启了GPS或网络定位开关
     *
     * @return
     */
    fun isLocationProviderEnabled(context: Context): Boolean {
        var result = false
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            result = true
        }
        return result
    }

    /**
     * 获取地理位置，先根据GPS获取，再根据网络获取
     *
     * @return
     */
    @SuppressLint("MissingPermission")
    private fun getLocationByNetwork(context: Context, callback: Callback) {
        val locationListener: LocationListener = getLocationListener(callback)

        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        try {
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f, locationListener)
            }
        } catch (e: Exception) {
            e.message?.let { Log.e(TAG, it) }
        }
    }
}

interface Callback {
    fun onLocationChanged(location: Location)
}