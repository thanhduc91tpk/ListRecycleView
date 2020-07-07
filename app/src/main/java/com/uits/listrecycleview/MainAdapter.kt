package com.uits.listrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uits.listrecycleview.interfaces.OnItemClickListener
import kotlinx.android.synthetic.main.viewholder_item.view.*

/**
 * Adapter for Main screen
 * Copyright © 2019 UITS CO.,LTD
 * Created PHUQUY on 7/1/20.
 **/
class MainAdapter(val mList: MutableList<Singer>, val mListener : OnItemClickListener) : RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {

    /**
     * create a view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_item, parent, false)
        )
    }

    /**
     * size on list
     */
    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var singer : Singer = mList.get(position)
        holder.txtName.text = singer.mName
        holder.txtSong.text = singer.mSong

        holder.itemView.setOnClickListener{
            mListener.onItemClick(position)
        }
    }


    /**
     * this ItemViewHolder class
     */
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName = itemView.findViewById<TextView>(R.id.txt_singer)
        var txtSong = itemView.findViewById<TextView>(R.id.txt_song)
    }
}