package com.joyrun.base

import com.dbflow5.annotation.Database
import com.joyrun.base.MyDatabase.Companion.VERSION_CODE

/**
 * author: wneJie
 * date: 2019-09-24 19:01
 * desc:
 */
@Database(version = VERSION_CODE)
class MyDatabase {

    companion object{
        const val VERSION_CODE = 1
    }
}