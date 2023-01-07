package com.example.practice_day3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice_day3.databinding.ActivityRecycleViewPageBinding

class RecycleViewPage : AppCompatActivity() {
    val binding by lazy{
        ActivityRecycleViewPageBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fun longData () : MutableList<Memo> {
            val data : MutableList<Memo> = mutableListOf()
            for(no in 1 .. 100){
                val title = "이것이 안드로이드다 ${no}"
                val date = System.currentTimeMillis()
                var memo = Memo(no,title,date)
                data.add(memo)
            }
            return data
        }
        val data : MutableList<Memo> = longData()

        var adapter = CustomAdapter()
        adapter.listData = data

        binding.recycleView.adapter = adapter
        binding.recycleView.layoutManager = LinearLayoutManager(this)

    }
}