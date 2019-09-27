package com.joyrun.home

import com.grouter.RouterComponent
import com.joyrun.base.service.IHomeService

/**
 * author: wneJie
 * date: 2019-09-24 16:55
 * desc:
 */
@RouterComponent(value = "HomeService" , protocol = IHomeService::class)
class HomeService : IHomeService{

    override fun newHomeFragment() = HomeFragment()
}