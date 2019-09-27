package com.joyrun.base

import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.http.ACache

/**
 * author: wneJie
 * date: 2019-09-24 11:04
 * desc:
 */
class UserManager private constructor(private val aCache: ACache = ACache.get(BaseApplication.globalApplicationContext)) {

    companion object {
        private var instance: UserManager? = null
            get() {
                if (field == null) {
                    field = UserManager()
                }
                return field
            }

        @Synchronized
        fun get(): UserManager {
            return instance!!
        }
    }


    fun saveUserInfo(userInfo: UserInfo) {
        aCache.put("userInfo", userInfo)
    }

    fun getUserInfo(): UserInfo? {
        return aCache.getAsObject("userInfo") as UserInfo?
    }

    fun saveToken(token: String) {
        aCache.put("token", token)
    }

    fun getToken(): String? {
        return aCache.getAsString("token")
    }

    fun loginout() {
        aCache.remove("userInfo")
        aCache.remove("token")
    }


    /**
     * 获取用的登录状态
     */
    fun getLoginStatus(): Boolean {
        return aCache.getAsString("token")?.let {
            true
        } ?: let {
            false
        }
    }

}