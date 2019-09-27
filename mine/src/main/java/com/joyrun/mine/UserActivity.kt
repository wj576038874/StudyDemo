package com.joyrun.mine

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.grouter.GRouter
import com.grouter.RouterActivity
import com.grouter.RouterField
import com.joyrun.base.UserManager
import kotlinx.android.synthetic.main.mine_user_activity.*

/**
 * author: wneJie
 * date: 2019-09-25 11:44
 * desc:
 */
@RouterActivity(value = "personal/UserActivity" , exported = false)
class UserActivity : AppCompatActivity() {

    @RouterField
    var name: String? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_user_activity)
        GRouter.inject(this)

        tv_user.text = name + UserManager.get().getUserInfo()
    }
}