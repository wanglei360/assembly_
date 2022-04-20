package com.kts.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.baselibrary.MLibActivity
import com.kts.projectdemo.DemoActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun btn1(view: View) {
        Intent(this, MLibActivity::class.java).apply {
            putExtra("aaa", "112233,,,,>>>>")
            startActivity(this)
        }
    }

    fun btn2(view: View) {
        Intent(this, DemoActivity::class.java).apply {
            putExtra("aaa", "112233,,,,>>>>")
            startActivity(this)
        }
    }

}