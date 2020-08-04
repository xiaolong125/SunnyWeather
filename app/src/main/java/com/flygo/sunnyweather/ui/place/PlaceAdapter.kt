package com.flygo.sunnyweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.flygo.sunnyweather.R
import com.flygo.sunnyweather.logic.model.Place
import kotlinx.android.synthetic.main.place_item.view.*

/**
 * 作者：ly-xuxiaolong
 * 版本：1.0
 * 创建日期：2020/8/3
 * 描述：
 * 修订历史：
 */
class PlaceAdapter(private val fragment: Fragment,private val placeList: List<Place>) :RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val placeName:TextView = view.findViewById(R.id.placeName)
        val placeAddress:TextView = view.findViewById(R.id.placeAddress)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = placeList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address
    }
}