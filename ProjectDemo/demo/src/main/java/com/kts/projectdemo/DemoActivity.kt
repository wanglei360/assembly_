package com.kts.projectdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_layout)

        findViewById<TextView>(R.id.dd_tv)?.apply {
            intent.getStringExtra("aaa")?.apply {
                text = "$this   ${this@DemoActivity.javaClass.name}"
            }
        }
    }
}