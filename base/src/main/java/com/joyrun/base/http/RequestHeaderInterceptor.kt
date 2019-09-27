package com.joyrun.base.http


import com.joyrun.base.BaseApplication
import com.joyrun.base.UserManager

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class RequestHeaderInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        //        //@Headers("type:xxx")//区分请求
        //        //String str = request.headers().get("type");

        val original = chain.request()
        // 如果当前没有缓存 token 或者请求已经附带 token 了，就不再添加
        if (null == UserManager.get().getToken() || alreadyHasAuthorizationHeader(original)) {
            return chain.proceed(original)
        }
        val token = "Bearer " + UserManager.get().getToken()
        val request = original.newBuilder()
            .header("Authorization", token)
            .build()
        return chain.proceed(request)
    }

    private fun alreadyHasAuthorizationHeader(originalRequest: Request): Boolean {
        val token = originalRequest.header("Authorization")
        // 如果本身是请求 token 的 URL，直接返回 true
        // 如果不是，则判断 header 中是否已经添加过 Authorization 这个字段，以及是否为空
        return !(null == token || token.isEmpty() || originalRequest.url.toString().contains("https://www.diycode.cc/oauth/token"))
    }
}
