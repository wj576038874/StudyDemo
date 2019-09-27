package com.joyrun.base.coroutine

/**
 * author: wneJie
 * date: 2019-09-26 15:38
 * desc:
 */

class RetrofitRequestDSL<T> {


    //var 变量名 : (参数的类型，参数类型，...) -> 返回值类型 = {参数1，参数2，... -> 操作参数的代码 }

    internal var onStart: (() -> Unit)? = null

    internal var request: (suspend () -> T)? = null

    internal var onSuccess: ((T) -> Unit)? = null

    internal var onError: ((String, String) -> Unit)? = null

    internal var onComplete: (() -> Unit)? = null


    fun onStart(onStart : () -> Unit){
        this.onStart = onStart
    }

    fun request(request: suspend () -> T) {
        this.request = request
    }

    fun onSuccess(onSuccess: (T) -> Unit) {
        this.onSuccess = onSuccess
    }

    fun onError(onError: (msg: String, code: String) -> Unit) {
        this.onError = onError
    }

    fun onComplete(onComplete: () -> Unit) {
        this.onComplete = onComplete
    }

}