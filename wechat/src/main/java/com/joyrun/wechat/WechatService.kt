package com.joyrun.wechat
import com.grouter.RouterComponent
import com.joyrun.base.service.IWachatService

/**
 * author: wneJie
 * date: 2019-09-24 18:08
 * desc:
 */
@RouterComponent(value = "WechatService" , protocol = IWachatService::class)
class WechatService : IWachatService {
    override fun newnewsFragment()= WechatFragment()
}