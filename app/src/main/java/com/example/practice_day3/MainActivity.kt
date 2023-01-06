package com.example.practice_day3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import android.widget.Toast
import com.example.practice_day3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this,SubActivity::class.java)
        intent.putExtra("fromA","hello bundle")
        intent.putExtra("fromB",2023)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    binding.radioGroup.setOnCheckedChangeListener { radioGroup, checked ->
        if(R.id.btn_apple ==checked && R.id.btnBanana == checked){
            binding.textView.text = "애플과 바나나가 체크되었습니다."
        }
    }
        binding.btnNext.setOnClickListener {
            startActivityForResult(intent,99)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == RESULT_OK){
            when(resultCode){
                99 -> {
                    val message = data?.getStringExtra("returnValue")
                    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
                }
                else -> println("no")

            }

        }
    }
}