package com.techdoctorbd.draganddroprecyclerview

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.techdoctorbd.draganddroprecyclerview.adapters.MyRecyclerAdapter
import com.techdoctorbd.draganddroprecyclerview.helper.MyItemTouchHelperCallback
import com.techdoctorbd.draganddroprecyclerview.helper.OnStartDragListener
import com.techdoctorbd.draganddroprecyclerview.models.ItemModel
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
        val data: MutableList<ItemModel?> = ArrayList()
        data.add(ItemModel(1,"One"))
        data.add(ItemModel(2,"Two"))
        data.add(ItemModel(3,"Three"))
        data.add(ItemModel(4,"Four"))
        data.add(ItemModel(5,"Five"))
        data.add(ItemModel(6,"Six"))
        data.add(ItemModel(7,"Seven"))
        data.add(ItemModel(8,"Eight"))
        data.add(ItemModel(9,"Nine"))
        data.add(ItemModel(10,"Ten"))
        data.add(ItemModel(11,"Eleven"))
        data.add(ItemModel(12,"Twelve"))
        data.add(ItemModel(13,"Thirteen"))
        data.add(ItemModel(14,"Fourteen"))
        data.add(ItemModel(15,"Fifteen"))
        data.add(ItemModel(16,"Sixteen"))
        data.add(ItemModel(17,"Seventeen"))
        data.add(ItemModel(18,"Eighteen"))
        data.add(ItemModel(19,"Nineteen"))
        data.add(ItemModel(20,"Twenty"))

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