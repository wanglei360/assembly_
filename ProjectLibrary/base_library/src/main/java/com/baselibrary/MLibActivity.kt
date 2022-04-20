package com.baselibrary

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/** * 创建者：leiwu
 * * 时间：2022/4/20 13:42
 * * 类描述：
 * * 修改人：
 * * 修改时间：
 * * 修改备注：
 */
class MLibActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lib_demo_layout)

        findViewById<TextView>(R.id.da_tv)?.apply {
            intent.getStringExtra("aaa")?.apply {
                text = "$this   ${this@MLibActivity.javaClass.name}"
            }
        }

    }
}