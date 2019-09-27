package com.joyrun.wechat

import android.app.Application
import com.joyrun.base.BaseApplication
import com.joyrun.base.coroutine.log

/**
 * author: wneJie
 * date: 2019-09-25 14:34
 * desc:
 */
class WechatApplication : BaseApplication() {


    override fun onCreate() {
        super.onCreate()
        onCreateApplication(this)
    }


    override fun onCreateApplication(application: Application) {
        super.onCreateApplication(application)
        "WechatApplication onCreateApplication".log()
    }
}