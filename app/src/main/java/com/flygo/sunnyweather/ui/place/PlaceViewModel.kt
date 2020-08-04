package com.flygo.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.flygo.sunnyweather.logic.Repository
import com.flygo.sunnyweather.logic.model.Place

/**
 * 作者：ly-xuxiaolong
 * 版本：1.0
 * 创建日期：2020/8/3
 * 描述：
 * 修订历史：
 */
class PlaceViewModel :ViewModel(){

    private val searchLiveData = MutableLiveData<String>()

    //给界面显示用的
    val placeList = ArrayList<Place>()

    //searchLiveData的值发生变化的时候会调用Transformations.switchMap方法，
    // 然后去Repository调用网络请求，返回一个liveData给界面观察
    val placeLiveData = Transformations.switchMap(searchLiveData){
        Repository.searchPlace(it)
    }

    //给界面调用的方法
    fun searchPlaces(query:String){
        searchLiveData.value = query
    }
}