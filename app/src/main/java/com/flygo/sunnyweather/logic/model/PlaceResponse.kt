package com.flygo.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * 作者：ly-xuxiaolong
 * 版本：1.0
 * 创建日期：2020/8/3
 * 描述：
 * 修订历史：
 */
data class PlaceResponse(val status:String,val places:List<Place>)

data class Place(val name:String,val location:Location,@SerializedName("formatted_address") val address:String)

data class Location(val lng:String,val lat:String)