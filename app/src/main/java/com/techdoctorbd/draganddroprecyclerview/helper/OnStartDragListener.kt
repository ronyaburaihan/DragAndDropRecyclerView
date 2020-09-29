package com.techdoctorbd.draganddroprecyclerview.helper

import androidx.recyclerview.widget.RecyclerView

interface OnStartDragListener {
    fun onStartDrag(viewHolder: RecyclerView.ViewHolder?)
}