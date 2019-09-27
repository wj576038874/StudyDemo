package com.joyrun.base.http

import androidx.lifecycle.Observer


abstract class ResponseCallback<T> : Observer<ResponseResource<T>> {

    override fun onChanged(tResponseResource: ResponseResource<T>) {
        when (tResponseResource.status) {
            ResponseResource.Status.LOADING -> loading()
            ResponseResource.Status.ERROR -> error(tResponseResource.message)
            ResponseResource.Status.SUCCESS -> success(tResponseResource.data!!)
        }
    }


    abstract fun success(data: T)

    abstract fun error(msg: String?)

    open fun loading() {

    }


    /**
     * 某些情况下 需要拿到服务器返回的code做业务处理
     *
     * @param code code
     * @param msg  msg
     */
    fun error(code: String, msg: String) {
        error(msg)
    }
}
