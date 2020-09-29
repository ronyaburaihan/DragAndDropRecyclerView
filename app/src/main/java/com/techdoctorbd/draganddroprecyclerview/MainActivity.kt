package com.techdoctorbd.draganddroprecyclerview

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.techdoctorbd.draganddroprecyclerview.adapters.MyRecyclerAdapter
import com.techdoctorbd.draganddroprecyclerview.helper.MyItemTouchHelperCallback
import com.techdoctorbd.draganddroprecyclerview.helper.OnStartDragListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var itemTouchHelper: ItemTouchHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            hasFixedSize()
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

        generateItem()
    }

    private fun generateItem() {
        val data: MutableList<String?> = ArrayList()
        data.addAll(
            mutableListOf(
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
                "Ten",
                "Eleven",
                "Twelve",
                "Thirteen",
                "Fourteen",
                "Fifteen",
                "Sixteen",
                "Seventeen",
                "Eighteen",
                "Nineteen",
                "Twenty"
            )
        )

        val adapter = MyRecyclerAdapter(this, data, object : OnStartDragListener {
            override fun onStartDrag(viewHolder: RecyclerView.ViewHolder?) {
                itemTouchHelper!!.startDrag(viewHolder!!)
            }

        })

        recyclerView.adapter = adapter
        val callback = MyItemTouchHelperCallback(adapter)
        itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper!!.attachToRecyclerView(recyclerView)
    }
}