package com.joyrun.home

import android.app.Application
import android.util.Log
import com.joyrun.base.BaseApplication
import com.joyrun.base.coroutine.log

/**
 * author: wneJie
 * date: 2019-09-25 14:30
 * desc:
 */
class HomeApplication : BaseApplication() {


    override fun onCreate() {
        super.onCreate()
        onCreateApplication(this)
    }


    override fun onCreateApplication(application: Application) {
        super.onCreateApplication(application)
        "HomeApplication onCreateApplication".log()
    }

}