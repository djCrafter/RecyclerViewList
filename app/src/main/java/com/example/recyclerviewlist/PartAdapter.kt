package com.example.recyclerviewlist

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.part_list_item.view.*
import kotlinx.android.synthetic.main.part_list_item2.view.*


class PartAdapter (val partItemList: List<PartData>, val clickListener: (PartData) -> Unit) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CellType.SIMPLE_ITEM.ordinal -> SimplePartViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.part_list_item, parent, false))
            CellType.MODERN_ITEM.ordinal -> ModernPartViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.part_list_item2, parent, false))
            else ->  SimplePartViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.part_list_item, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            CellType.SIMPLE_ITEM.ordinal -> {
                val headerViewHolder = holder as SimplePartViewHolder
                headerViewHolder.bind(partItemList[position], clickListener)
            }
            CellType.MODERN_ITEM.ordinal -> {
                val headerViewHolder = holder as ModernPartViewHolder
                headerViewHolder.bind(partItemList[position], clickListener)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
            if (position % 2 == 0)
                return CellType.SIMPLE_ITEM.ordinal
            else
                return CellType.MODERN_ITEM.ordinal
    }

    override fun getItemCount() = partItemList.size


    class SimplePartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: PartData, clickListener: (PartData) -> Unit){
            itemView.tv_part_item_name.text = part.itemName
            itemView.tv_part_item_name.setBackgroundColor(Color.parseColor("#7FFF00"))
            itemView.setOnClickListener{ clickListener(part) }
        }
    }

    class ModernPartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: PartData, clickListener: (PartData) -> Unit){
            itemView.tv_part_item2_name.text = part.itemName
            itemView.tv_part_item2_name.setBackgroundColor(Color.parseColor("#00BFFF"))
            itemView.itemImage.setImageResource(part.pict!!)
            itemView.itemImage.setBackgroundColor(Color.parseColor("#00BFFF"))
            itemView.setOnClickListener{ clickListener(part) }
        }
    }

    enum class CellType(viewType: Int) {
        SIMPLE_ITEM(0),
        MODERN_ITEM(1)
    }
}