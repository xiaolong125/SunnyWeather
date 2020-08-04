package com.flygo.sunnyweather

import android.app.Application
import android.content.Context

/**
 * 作者：ly-xuxiaolong
 * 版本：1.0
 * 创建日期：2020/8/3
 * 描述：
 * 修订历史：
 */
class SunnyWeatherApplication :Application(){

    companion object{
        @SuppressWarnings("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "GzsVfbrYsnyPPCP6"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext;
    }
}