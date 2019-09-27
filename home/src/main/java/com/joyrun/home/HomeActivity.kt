package com.joyrun.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_main)
        val ft= supportFragmentManager.beginTransaction()
        ft.add(R.id.fl_content, HomeFragment())
        ft.commit()
    }
}
