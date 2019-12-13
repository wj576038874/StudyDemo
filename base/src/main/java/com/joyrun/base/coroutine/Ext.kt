package com.joyrun.base.coroutine

import android.text.TextUtils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joyrun.base.http.BaseResponse
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception
import java.net.ConnectException
import java.net.SocketTimeoutException

/**
 * author: wneJie
 * date: 2019-09-30 12:08
 * desc:
 */

//fun <T> ViewModel.loadData(block: RetrofitRequestDSL<T>.() -> Unit) {
//
//    RetrofitRequestDSL<T>().apply {
//        block()
//        onStart?.invoke()
//        viewModelScope.launch {
//
//            try {
////                    val s = request?.invoke()
////                    if (s != null){
////                        onSuccess?.invoke(s)
////                    }else{
////                        onError?.invoke("asd","")
////                    }
//
//                request?.let {
//
//                    when (val response = it()) {
//                        is BaseResponse<*> -> {
//                            //统一处理只有code为00000时才是成功，其他情况均为失败
//                            if (response.errorCode == 0) {
//                                onSuccess?.invoke(response)
////                                    onSuccess!!(response)
//                            } else {
//                                onError?.invoke(
//                                    response.errorCode.toString(),
//                                    response.errorMsg
//                                )//onError("","")
//                            }
//                        }
//                        else -> {
//                            onSuccess?.invoke(response)
//                        }
//                    }
//                } ?: let {
//                    onError?.invoke("请求出错了！request not be null", "-1")
//                }
//            } catch (throwable: Exception) {
//                val msg: String = when (throwable) {
//                    is HttpException -> {
//                        when (throwable.code()) {
//                            400 -> "手机号或验证码错误"
//                            401 -> "token失效,请重新登录"
//                            else -> "请求出错了，错误代码" + throwable.code()
//                        }
//                    }
//                    is SocketTimeoutException -> "请求超时。请稍后重试！"
//                    is ConnectException -> "请求超时。请稍后重试！"
//                    else -> "请求出错了。请稍后重试！${throwable.message}"
//                }
//                if (!TextUtils.isEmpty(msg)) {
//                    onError?.invoke(msg, "-1")
//                }
//            } finally {
//                //请求完成之后
//                onComplete?.invoke()
//            }
//        }
//    }
//
//}