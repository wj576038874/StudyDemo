package com.joyrun.base

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import com.dbflow5.config.FlowManager
import com.grouter.GRouter
import com.joyrun.base.BuildConfig

/**
 * author: wneJie
 * date: 2019-09-24 17:03
 * desc:
 */
open class BaseApplication : Application() , IComponentApplication{

    override fun onCreateApplication(application: Application) {
        
    }

    companion object {
        /**
         * 获取全局ApplicationContext
         */
        lateinit var globalApplicationContext: Context
            private set
        /**
         * 获取创建在主线程上的Handler对象。
         *
         * @return 创建在主线程上的Handler对象。
         */
        lateinit var mHandler: Handler
            private set

    }

    override fun onCreate() {
        super.onCreate()
        globalApplicationContext = this
        mHandler = Handler(Looper.getMainLooper())
        GRouter.getInstance().init(this, BuildConfig.BUILD_TYPE, null)
        FlowManager.init(this)
    }
}