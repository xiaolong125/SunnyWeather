package com.flygo.sunnyweather.logic

import androidx.lifecycle.liveData
import com.flygo.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException

/**
 * 作者：ly-xuxiaolong
 * 版本：1.0
 * 创建日期：2020/8/3
 * 描述：
 * 修订历史：
 */
object Repository {
    //仓库层调用网络层，将结果转成liveData
    fun searchPlace(query:String) = liveData(Dispatchers.IO){
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status =="ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure<List<com.flygo.sunnyweather.logic.model.Place>>(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<com.flygo.sunnyweather.logic.model.Place>>(e)
        }
        emit(result)
    }
}