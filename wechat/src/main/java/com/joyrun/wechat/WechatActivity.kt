package com.joyrun.wechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WechatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wechat_activity_news)
        val ft= supportFragmentManager.beginTransaction()
        ft.add(R.id.fl_content, WechatFragment())
        ft.commit()
    }
}
