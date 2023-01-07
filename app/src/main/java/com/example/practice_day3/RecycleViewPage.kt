package com.example.practice_day3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice_day3.databinding.ActivityRecycleViewPageBinding

class RecycleViewPage : AppCompatActivity() {
    val binding by lazy{
        ActivityRecycleViewPageBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}