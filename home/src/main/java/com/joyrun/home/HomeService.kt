package com.joyrun.home

import android.content.Context
import com.grouter.RouterComponent
import com.grouter.RouterComponentConstructor
import com.joyrun.base.service.IHomeService

/**
 * author: wneJie
 * date: 2019-09-24 16:55
 * desc:
 */
@RouterComponent(value = "HomeService" , protocol = IHomeService::class)
class HomeService : IHomeService{


    private var context:Context? = null

    constructor()

    @RouterComponentConstructor
    constructor(context: Context) {
        this.context = context
    }

    override fun newHomeFragment() = HomeFragment()
}