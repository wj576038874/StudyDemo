package com.joyrun.base.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import java.io.IOException
import java.net.ConnectException

/**
 * author: wneJie
 * date: 2019-09-26 15:29
 * desc:
 */


fun <ResultType> CoroutineScope.retrofit(dsl: RetrofitCoroutineDsl<ResultType>.() -> Unit) {
    this.launch(Dispatchers.Main) {
        val retrofitCoroutine = RetrofitCoroutineDsl<ResultType>()
        retrofitCoroutine.dsl()
        retrofitCoroutine.api?.let { it ->
            val work = async(Dispatchers.IO) {
                // io线程执行
                try {
                    it.execute()
                } catch (e: ConnectException) {
                    retrofitCoroutine.onFailed?.invoke("网络连接出错", -100)
                    null
                } catch (e: IOException) {
                    retrofitCoroutine.onFailed?.invoke("未知网络错误", -1)
                    null
                }
            }
            work.invokeOnCompletion { _ ->
                // 协程关闭时，取消任务
                if (work.isCancelled) {
                    it.cancel()
                    retrofitCoroutine.clean()
                }
            }
            val response = work.await()
            retrofitCoroutine.onComplete?.invoke()
            response?.let {
                if (response.isSuccessful) {
                    retrofitCoroutine.onSuccess?.invoke(response.body())
                } else {
                    // 处理 HTTP code
                    when (response.code()) {
                        401 -> {
                        }
                        500 -> {
                        }
                    }
                    retrofitCoroutine.onFailed?.invoke(response.errorBody().toString(), response.code())
                }
            }
        }
    }
}

class RetrofitCoroutineDsl<ResultType> {
    var api: (Call<ResultType>)? = null

    internal var onSuccess: ((ResultType?) -> Unit)? = null
        private set
    internal var onComplete: (() -> Unit)? = null
        private set
    internal var onFailed: ((error: String?, code: Int) -> Unit)? = null
        private set

    var showFailedMsg = false

    internal fun clean() {
        onSuccess = null
        onComplete = null
        onFailed = null
    }

    fun onSuccess(block: (ResultType?) -> Unit) {
        this.onSuccess = block
    }

    fun onComplete(block: () -> Unit) {
        this.onComplete = block
    }

    fun onFailed(block: (error: String?, code: Int) -> Unit) {
        this.onFailed = block
    }

}