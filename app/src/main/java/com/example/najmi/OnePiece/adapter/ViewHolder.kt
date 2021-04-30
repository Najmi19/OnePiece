package com.example.najmi.OnePiece.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.najmi.OnePiece.entity.Item
import kotlinx.android.synthetic.main.item_list.view.*


class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bindItem(item: Item, listener: (Item) -> Unit) {
        itemView.name.text = item.name
        Glide.with(itemView.context).load(item.image).into(itemView.image)

        itemView.setOnClickListener {
            listener(item)
        }
    }
}
