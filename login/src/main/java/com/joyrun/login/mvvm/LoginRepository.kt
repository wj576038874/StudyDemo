package com.joyrun.login.mvvm

import com.joyrun.base.UserManager
import com.joyrun.base.entity.login.Token
import com.joyrun.base.entity.login.UserInfo
import com.joyrun.base.http.NetImpl
import com.joyrun.base.http.ResponseCallback
import com.joyrun.login.LoginApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

/**
 * author: wneJie
 * date: 2019-09-25 12:01
 * desc:
 */
class LoginRepository : NetImpl<LoginApi>() {

    fun token(responseCallback: ResponseCallback<Response<Token>>) {
        subscribe(mApiService.getToken("", "", "password", "wj576038874", "1rujiwang"),
            object : ResponseCallback<Response<Token>>() {
                override fun success(data: Response<Token>) {
                    responseCallback.success(data)
                }

                override fun error(msg: String?) {
                    responseCallback.error(msg)
                }
            })
    }

    fun login(
        responseCallback: ResponseCallback<Response<UserInfo>>
    ) {
        subscribe(mApiService.getToken("", "", "password", "wj576038874", "1rujiwang").flatMap {
            if (it.isSuccessful) {
                it.body()?.run {
                    access_token.run {
                        UserManager.get().saveToken(access_token)
                        return@flatMap mApiService.getMe()
                    }
                } ?: run {
                    throw HttpException(it)
                }
            } else {
                throw HttpException(it)
            }
        }.map {
            return@map it
        }, object : ResponseCallback<Response<UserInfo>>() {
            override fun success(data: Response<UserInfo>) {
                responseCallback.success(data)
            }

            override fun error(msg: String?) {
                responseCallback.error(msg)
            }
        })
    }


    fun login2(responseCallback: ResponseCallback<Response<UserInfo>>) {
        MainScope().launch {
            val responseToken = mApiService.getToken2("", "", "password", "wj576038874", "1rujiwang")
            responseToken.body()?.let {
                UserManager.get().saveToken(it.access_token)
            }
            val userInfoResp = mApiService.getMe2()
            responseCallback.success(userInfoResp)
        }
    }
}