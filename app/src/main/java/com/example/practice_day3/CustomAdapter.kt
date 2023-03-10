package com.example.practice_day3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_day3.databinding.ItemRecyclesBinding
import java.text.SimpleDateFormat


class Holder(val binding : ItemRecyclesBinding) : RecyclerView.ViewHolder(binding.root){
fun setMemo(memo : Memo){
    binding.textNo.text = "${memo.no}"
    binding.textTitle.text = "${memo.title}"
    binding.textDate.text = SimpleDateFormat("yyyy/mm/dd").format(memo.timeStamp)
}

}
class CustomAdapter : RecyclerView.Adapter<Holder>(){
    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}