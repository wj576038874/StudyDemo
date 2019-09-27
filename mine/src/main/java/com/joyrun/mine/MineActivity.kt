package com.joyrun.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_activity_personal)
        val ft= supportFragmentManager.beginTransaction()
        ft.add(R.id.fl_content, MineFragment())
        ft.commit()
    }
}
