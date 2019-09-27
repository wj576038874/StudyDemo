package com.joyrun.study.interceptor

import android.content.Context
import android.widget.Toast
import com.grouter.ActivityRequest
import com.grouter.GActivityCenter
import com.grouter.GRouterInterceptor
import com.grouter.RouterInterceptor
import com.joyrun.base.UserManager

/**
 * author: wneJie
 * date: 2019-09-25 11:52
 * desc:
 */
@RouterInterceptor
class LoginInterceptor : GRouterInterceptor() {

    /**
     * 没有登录状态下可以访问的页面
     */
//    private val visitorAccess = listOf(
//        GActivityCenter.LoginActivity().javaClass.name
//    )

    override fun init(context: Context, buildType: String?, params: MutableMap<String, Any>?) {
        super.init(context, buildType, params)
    }

    override fun process(request: ActivityRequest): Boolean {
//        if (!visitorAccess.contains(request.activityClass)){
//            if (!UserManager.get().getLoginStatus()) {
//                Toast.makeText(request.context, "请登录", Toast.LENGTH_SHORT).show()
//                request.onContinue(GActivityCenter.LoginActivity())
//                GActivityCenter.LoginActivity().start(request.context)
//                return true
//            }else{
//                return super.process(request)
//            }
//        }else{
//            return super.process(request)
//        }

        return if (!UserManager.get().getLoginStatus()) {
            Toast.makeText(request.context, "请登录", Toast.LENGTH_SHORT).show()
            request.onContinue(GActivityCenter.LoginActivity())
            true
        } else {
            super.process(request)
        }

//        return super.process(request)
    }
}