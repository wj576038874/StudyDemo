package com.joyrun.mine
import com.grouter.RouterComponent
import com.joyrun.base.service.IMineService

/**
 * author: wneJie
 * date: 2019-09-24 18:10
 * desc:
 */
@RouterComponent(value = "MineService" , protocol = IMineService::class)
class MineService : IMineService{
    override fun newPersonalFragment() = MineFragment()
}