package com.example.practice_day3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practice_day3.databinding.ActivityMainBinding
import com.example.practice_day3.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    val bindings by lazy {
        ActivitySubBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindings.root)
        bindings.to1.text = intent.getStringExtra("fromA")
        bindings.to2.text = intent.getIntExtra("fromB",0).toString()
        bindings.btnClose.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("returnValue",bindings.editMassage.text)
            setResult(RESULT_OK,returnIntent)
            finish()
        }

    }
}