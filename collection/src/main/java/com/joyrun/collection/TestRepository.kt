package com.joyrun.collection

import com.joyrun.base.coroutine.RetrofitHelper
import com.joyrun.base.entity.login.UserInfo

/**
 * author: wneJie
 * date: 2019-09-30 10:10
 * desc:
 */

class TestRepository {

    suspend fun login():UserInfo{
        return RetrofitHelper.getApiService(CollectionApi::class.java).getMe()
    }

}