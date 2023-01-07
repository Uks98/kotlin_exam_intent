package com.example.practice_day3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.Toast
import com.example.practice_day3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this,SubActivity::class.java)
        val recycleIntent = Intent(this,RecycleViewPage::class.java)
        intent.putExtra("fromA","hello bundle")
        intent.putExtra("fromB",2023)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            startActivityForResult(intent,99)
        }
        binding.btnRecycle.setOnClickListener {
            startActivity(recycleIntent)
        }
        var data = mutableListOf("--선택하세요--","1월","2월","3월","4월","5월","6월")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                binding.result.text = data.get(position)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_OK) {
            when (resultCode) {
                99 -> {
                    val message = data?.getStringExtra("returnValue")
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }
                else -> println("no")

            }

        }
    }
}