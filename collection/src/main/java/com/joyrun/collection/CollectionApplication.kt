package com.joyrun.collection

import android.app.Application
import com.joyrun.base.BaseApplication
import com.joyrun.base.coroutine.log

/**
 * author: wneJie
 * date: 2019-09-25 16:59
 * desc:
 */
class CollectionApplication : BaseApplication() {


    override fun onCreate() {
        super.onCreate()
        onCreateApplication(this)
    }


    override fun onCreateApplication(application: Application) {
        super.onCreateApplication(application)
        "CollectionApplication onCreateApplication".log()
    }
}