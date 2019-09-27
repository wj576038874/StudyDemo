package com.joyrun.study

import android.app.Application
import android.util.Log
import com.joyrun.base.AppConfig
import com.joyrun.base.BaseApplication
import com.joyrun.base.IComponentApplication


/**
 * author: wneJie
 * date: 2019-09-24 17:02
 * desc:
 */
class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        onCreateApplication(this)
    }

    override fun onCreateApplication(application: Application) {
        super.onCreateApplication(application)
        Log.e("asd", "MainApplication onCreate")
        for (app in AppConfig.componentApplications) {
            try {
                val clazz = Class.forName(app)
                val componentApplication = clazz.newInstance() as IComponentApplication
                componentApplication.onCreateApplication(application)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            }


        }

    }
}