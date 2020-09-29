package com.techdoctorbd.draganddroprecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techdoctorbd.draganddroprecyclerview.R
import com.techdoctorbd.draganddroprecyclerview.helper.ItemTouchHelperAdapter
import com.techdoctorbd.draganddroprecyclerview.helper.OnStartDragListener
import kotlinx.android.synthetic.main.layout_recycler_item.view.*
import java.util.*

class MyRecyclerAdapter(
    var context: Context,
    var itemList: MutableList<String?>,
    var listener: OnStartDragListener
) : RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>(), ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.layout_recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.text_number.text = (position + 1).toString()
        holder.itemView.text_description.text = itemList[position]

        //Event
        holder.itemView.item.setOnLongClickListener {
            listener.onStartDrag(holder)
            false
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(itemList, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemDismiss(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}