package com.joyrun.mine

import android.app.Application
import com.joyrun.base.BaseApplication
import com.joyrun.base.coroutine.log

/**
 * author: wneJie
 * date: 2019-09-25 14:35
 * desc:
 */
class MineApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        onCreateApplication(this)
    }

    override fun onCreateApplication(application: Application) {
        super.onCreateApplication(application)
        "MineApplication onCreateApplication".log()
    }
}