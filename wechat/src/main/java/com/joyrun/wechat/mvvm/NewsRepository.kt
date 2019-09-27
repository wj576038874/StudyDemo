package com.joyrun.wechat.mvvm

import com.joyrun.base.entity.news.NewsInfo
import com.joyrun.base.http.NetImpl
import com.joyrun.base.http.ResponseCallback
import com.joyrun.wechat.api.WechatApi

/**
 * author: wneJie
 * date: 2019-09-25 09:21
 * desc:
 */
class NewsRepository : NetImpl<WechatApi>() {


    fun getNewslist(offset: Int, limit: Int , responseCallback: ResponseCallback<List<NewsInfo>>) {
        subscribe(
            mApiService.getNewsList(offset, limit),
            object : ResponseCallback<List<NewsInfo>>() {
                override fun success(data: List<NewsInfo>) {
                    responseCallback.success(data)
                }

                override fun error(msg: String?) {
                    responseCallback.error(msg)
                }
            })
    }




}